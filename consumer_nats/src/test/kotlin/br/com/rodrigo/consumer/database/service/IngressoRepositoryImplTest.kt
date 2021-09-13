package br.com.rodrigo.consumer.database.service

import br.com.rodrigo.consumer.database.model.IngressoEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.MockKSettings.relaxed
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@MicronautTest
class IngressoRepositoryImplTest : AnnotationSpec() {

    val cqlSession = mockk<CqlSession>(relaxed = true)
    val ingressoRepositoryImpl = IngressoRepositoryImpl(cqlSession)

    lateinit var ingresso: IngressoEntity
    val id = UUID.randomUUID()

    @BeforeEach
    fun setUp() {
        ingresso = IngressoEntity(
            descricao = "Ingresso Teste Kotest", valor = BigDecimal(100.00),
            endereco = "Endereço 1", dataEvento = LocalDate.now()
        )
    }

    @Test
    fun `deve cadastrar um ingresso`() {
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

        val result = ingressoRepositoryImpl.cadastrar(ingresso)
        result shouldBe Unit
    }

    @Test
    fun `deve atualizar um ingresso`() {
        cqlSession.execute(
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

        val result = ingressoRepositoryImpl.atualizar(id, ingresso)
        result shouldBe Unit
    }

    @Test
    fun `deve deletar um ingresso`() {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "delete from ingresso where ingresso_id = ?;",
                id
            )
        )

        val result = ingressoRepositoryImpl.deletar(id)
        result shouldBe Unit
    }
}