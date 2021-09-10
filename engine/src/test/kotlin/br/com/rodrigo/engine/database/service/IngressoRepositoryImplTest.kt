package br.com.rodrigo.engine.database.service

import br.com.rodrigo.engine.database.model.IngressoEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@MicronautTest
class IngressoRepositoryImplTest : AnnotationSpec() {

    val cqlSession = mockk<CqlSession>(relaxed = true) //relaxed = true
    val ingressoRepositoryImp = IngressoRepositoryImpl(cqlSession)

    var id = UUID.randomUUID()
    lateinit var ingressoEntity: IngressoEntity

    @BeforeEach
    fun setUp() {
        ingressoEntity = IngressoEntity(
            id = id, descricao = "Ingresso Teste Kotest 1", valor = BigDecimal(100.00),
            endereco = "Endereço 1", dataEvento = LocalDate.now()
        )
    }

    @Test
    fun `nao deve retornar um ingresso por id`() {
        every {
            cqlSession.execute(
                SimpleStatement.newInstance("select * from ingresso where ingresso_id =?;", id)
            ).map { it ->
                IngressoEntity(
                    id = it.getUuid("ingresso_id"),
                    descricao = it.getString("descricao")!!,
                    valor = it.getBigDecimal("valor")!!,
                    endereco = it.getString("endereco")!!,
                    dataEvento = it.getLocalDate("data_evento")!!
                )
            }.firstOrNull()
        } answers { ingressoEntity }

        val result = ingressoRepositoryImp.buscarPorId(id)
        result shouldNotBe ingressoEntity
    }

    @Test
    fun `deve retornar sucesso quando buscar todos os ingressos`() {
        val selectResult = cqlSession.execute(
            SimpleStatement.newInstance("select * from ingresso LIMIT 10000")
        )

        val ingressosEntity = selectResult.map { it ->
            IngressoEntity(
                id = it.getUuid("ingresso_id"),
                descricao = it.getString("descricao")!!,
                valor = it.getBigDecimal("valor")!!,
                endereco = it.getString("endereco")!!,
                dataEvento = it.getLocalDate("data_evento")!!
            )
        }.toList()

        val result = ingressoRepositoryImp.buscarTodos()
        result shouldBe ingressosEntity
    }
}