package br.com.rodrigo.consumer.core.service

import br.com.rodrigo.consumer.core.model.Ingresso
import br.com.rodrigo.consumer.core.ports.IngressoRepositoryPort
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.time.LocalDate

@MicronautTest
class IngressoServiceImpTest : AnnotationSpec() {

    val ingressoRepository = mockk<IngressoRepositoryPort>()
    val ingressoServiceImp = IngressoServiceImp(ingressoRepository)

    lateinit var ingresso: Ingresso

    @BeforeEach
    fun setUp(){
        ingresso = Ingresso(descricao =  "Ingresso Teste Kotest", valor = BigDecimal(100.00),
            endereco =  "Endereço 1", dataEvento = LocalDate.now())
    }

    @Test
    fun `deve cadastrar um ingresso com sucesso`(){
        every { ingressoRepository.cadastrar(any()) } answers {Unit}
        val result = ingressoServiceImp.cadastrar(ingresso)
        result shouldBe Unit
    }
}