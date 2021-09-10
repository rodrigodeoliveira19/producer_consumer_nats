package br.com.rodrigo.engine.entrypoint.inbound

import br.com.rodrigo.engine.core.ports.IngressoServicePort
import br.com.rodrigo.engine.entrypoint.model.IngressoResponse
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@MicronautTest
class IngressoControllerTest : AnnotationSpec() {

    val ingressoService = mockk<IngressoServicePort>()
    val ingressoController = IngressoController(ingressoService)

    lateinit var ingressosResponse: IngressoResponse
    var id = UUID.randomUUID()

    @BeforeEach
    fun setUp(){
        ingressosResponse = IngressoResponse(
            id = id, descricao = "Ingresso Teste Kotest 1", valor = BigDecimal(100.00),
            endereco = "Endereço 1", dataEvento = LocalDate.now()
        )
    }

    @Test
    fun `deve retornar uma lista de ingressos`(){
        every { ingressoService.buscarTodos() } answers { mutableListOf(ingressosResponse)}
        val result =  ingressoController.buscarTodos()
        result.body() shouldBe mutableListOf(ingressosResponse)
    }

    @Test
    fun `deve retornar um ingresso por id`(){
        every { ingressoService.buscarPorId(any()) } answers {ingressosResponse}
        val result =  ingressoController.buscarPorId(id.toString())
        result.status shouldBe HttpStatus.OK
    }
}