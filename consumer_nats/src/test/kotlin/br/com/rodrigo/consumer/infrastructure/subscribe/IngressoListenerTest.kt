package br.com.rodrigo.consumer.infrastructure.subscribe

import br.com.rodrigo.consumer.core.ports.IngressoServicePort
import br.com.rodrigo.consumer.infrastructure.model.IngressoEvent
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@MicronautTest
class IngressoListenerTest : AnnotationSpec() {

    val ingressoService = mockk<IngressoServicePort>()
    val ingressoListener = IngressoListener(ingressoService)

    lateinit var ingresso: IngressoEvent
    var id = UUID.randomUUID()

    @BeforeEach
    fun setUp() {
        ingresso = IngressoEvent(
            descricao = "Ingresso Teste Kotest", valor = BigDecimal(100.00),
            endereco = "Endereço 1", dataEvento = LocalDate.now()
        )
    }

    @Test
    fun `deve cadastrar um ingresso`(){
        every { ingressoService.cadastrar(any()) } answers {Unit}
        val result = ingressoListener.cadastrar(ingresso)
        result shouldBe  Unit
    }

    @Test
    fun `deve atualizar um ingresso`(){
        every { ingressoService.atualizar(any(),any()) } answers {Unit}
        val result = ingressoListener.atualizar(Pair(id,ingresso))
        result shouldBe  Unit
    }

    @Test
    fun `deve deletar um ingresso`(){
        every { ingressoService.deletar(any()) } answers {Unit}
        val result = ingressoListener.delete(id)
        result shouldBe  Unit
    }
}