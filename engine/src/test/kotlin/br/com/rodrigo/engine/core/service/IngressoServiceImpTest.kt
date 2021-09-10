package br.com.rodrigo.engine.core.service

import br.com.rodrigo.engine.core.ports.IngressoRepository
import br.com.rodrigo.engine.database.model.IngressoEntity
import br.com.rodrigo.engine.entrypoint.model.IngressoResponse
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@MicronautTest
class IngressoServiceImpTest : AnnotationSpec() {

    val ingressoRepository = mockk<IngressoRepository>()
    val ingressoServiceImp = IngressoServiceImp(ingressoRepository)

    lateinit var ingressosEntity: IngressoEntity
    lateinit var ingressosResponse: IngressoResponse
    var id = UUID.randomUUID()

    @BeforeEach
    fun setUp() {

        ingressosEntity = IngressoEntity(
            id = id, descricao = "Ingresso Teste Kotest 1", valor = BigDecimal(100.00),
            endereco = "Endereço 1", dataEvento = LocalDate.now()
        )
        ingressosResponse = IngressoResponse(
            id = id, descricao = "Ingresso Teste Kotest 1", valor = BigDecimal(100.00),
            endereco = "Endereço 1", dataEvento = LocalDate.now()
        )
    }

    @Test
    fun `deve retornar uma lista de ingressos`() {
        every { ingressoRepository.buscarTodos() } answers { mutableListOf(ingressosEntity) }
        val result = ingressoServiceImp.buscarTodos()
        result shouldBe mutableListOf(ingressosResponse)
    }

    @Test
    fun `deve retornar um ingresso por id`() {
        every { ingressoRepository.buscarPorId(any())} answers {ingressosEntity }
        val result = ingressoServiceImp.buscarPorId(id.toString())
        result shouldBe ingressosResponse
    }
}