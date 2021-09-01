package br.com.rodrigo.engine.database.service


import br.com.rodrigo.engine.core.model.Ingresso
import br.com.rodrigo.engine.core.ports.IngressoRepository
import br.com.rodrigo.engine.database.model.IngressoEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import jakarta.inject.Singleton
import java.util.*

@Singleton
class IngressoRepositoryImpl(private val cqlSession: CqlSession) : IngressoRepository {

    override fun buscarTodos(): List<IngressoEntity> {
        val ingressos = cqlSession.execute(
            SimpleStatement.newInstance("select * from ingresso;")
        )

        return ingressos.map {
            IngressoEntity(
                id = it.getUuid("ingresso_id"),
                descricao = it.getString("descricao")!!,
                valor = it.getBigDecimal("valor")!!,
                endereco = it.getString("endereco")!!,
                dataEvento = it.getLocalDate("data_evento")!!
            )
        }.toList()
    }

    override fun buscarPorId(id: UUID): IngressoEntity? {
        val ingressos = cqlSession.execute(
            SimpleStatement.newInstance("select * from ingresso where ingresso_id =?;", id)
        )

        return ingressos.map {
            IngressoEntity(
                id = it.getUuid("ingresso_id"),
                descricao = it.getString("descricao")!!,
                valor = it.getBigDecimal("valor")!!,
                endereco = it.getString("endereco")!!,
                dataEvento = it.getLocalDate("data_evento")!!
            )
        }.firstOrNull()
    }
}