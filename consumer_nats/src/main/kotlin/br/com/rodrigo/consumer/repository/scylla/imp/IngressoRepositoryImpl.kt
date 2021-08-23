package br.com.rodrigo.consumer.repository.scylla.imp


import br.com.rodrigo.consumer.model.Ingresso
import br.com.zup.rodrigo.repository.scylla.IngressoRepository
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import jakarta.inject.Singleton
import java.util.*

@Singleton
class IngressoRepositoryImpl(private val cqlSession: CqlSession) : IngressoRepository {

    override fun cadastrar(ingresso: Ingresso) {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "insert into ingresso(ingresso_id, descricao, valor, endereco, data_evento) values (?, ?, ?, ?,?);",
                UUID.randomUUID(),
                ingresso.descricao,
                ingresso.valor,
                ingresso.endereco,
                ingresso.dataEvento
            )
        )
    }

    override fun atualizar(id: UUID,ingresso: Ingresso) {
        val ingressos = cqlSession.execute(
            SimpleStatement.newInstance(
                "update ingresso set descricao = ?, " +
                        "valor = ?, " +
                        "endereco = ?," +
                        "data_evento = ?" +
                        " where ingresso_id = ?;",
                ingresso.descricao,
                ingresso.valor,
                ingresso.endereco,
                ingresso.dataEvento,
                id
            )
        )
    }

    override fun deletar(id: UUID) {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "delete from ingresso where ingresso_id = ?;",
                id
            )
        )
    }
}