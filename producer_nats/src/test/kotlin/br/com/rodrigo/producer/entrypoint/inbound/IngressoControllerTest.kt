package br.com.rodrigo.producer.entrypoint.inbound

import br.com.rodrigo.producer.core.ports.IngressoServicePort
import br.com.rodrigo.producer.entrypoint.model.IngressoRequest
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.time.LocalDate

@MicronautTest
class IngressoControllerTest : AnnotationSpec() {

    val ingressoServicePort = mockk<IngressoServicePort>()
    val ingressoController = IngressoController(ingressoServicePort)

    lateinit var ingressoRequest: IngressoRequest
    lateinit var id: String

    @BeforeEach
    fun setUp(){
        ingressoRequest = IngressoRequest("descricao 1", BigDecimal(100.00),
            "Endereço 1", LocalDate.parse("2020-01-19"))

        id = "3275ddab-b95a-4ece-a5ab-e9ec220987a5"
    }

    @Test
    fun `cadastrar ingresso`(){
        every { ingressoServicePort.cadastrar(any()) } answers {Unit}
        val result = ingressoController.cadastrar(ingressoRequest)
        result.status shouldBe HttpStatus.OK
     }

    @Test
    fun `atualizar ingresso`(){
        every { ingressoServicePort.atualizar(any(), any()) } answers {Unit}
        val result = ingressoController.atualizar(id,ingressoRequest)
        result.status shouldBe HttpStatus.OK
    }

    @Test
    fun `deletar ingresso`(){
        every { ingressoServicePort.deletar(any()) } answers {Unit}
        val result = ingressoController.deletar(id)
        result.status shouldBe HttpStatus.OK
    }
}