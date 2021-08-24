package br.com.rodrigo.engine.repository.scylla.imp


import br.com.rodrigo.engine.model.Ingresso
import br.com.rodrigo.engine.repository.scylla.IngressoRepository
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import jakarta.inject.Singleton
import java.util.*

@Singleton
class IngressoRepositoryImpl(private val cqlSession: CqlSession) : IngressoRepository {

    override fun buscarTodos(): List<Ingresso> {
        val ingressos = cqlSession.execute(
            SimpleStatement.newInstance("select * from ingresso;")
        )

        return ingressos.map {
            Ingresso(
                id = it.getUuid("ingresso_id"),
                descricao = it.getString("descricao")!!,
                valor = it.getBigDecimal("valor")!!,
                endereco = it.getString("endereco")!!,
                dataEvento = it.getLocalDate("data_evento")!!
            )
        }.toList()
    }

    override fun buscarPorId(id: UUID): Ingresso? {
        val ingressos = cqlSession.execute(
            SimpleStatement.newInstance("select * from ingresso where ingresso_id =?;", id)
        )

        return ingressos.map {
            Ingresso(
                id = it.getUuid("ingresso_id"),
                descricao = it.getString("descricao")!!,
                valor = it.getBigDecimal("valor")!!,
                endereco = it.getString("endereco")!!,
                dataEvento = it.getLocalDate("data_evento")!!
            )
        }.firstOrNull()
    }
}