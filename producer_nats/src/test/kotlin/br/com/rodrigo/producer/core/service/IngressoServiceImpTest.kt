package br.com.rodrigo.producer.core.service

import br.com.rodrigo.producer.core.model.Ingresso
import br.com.rodrigo.producer.core.ports.IngressoClientPort
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@MicronautTest
class IngressoServiceImpTest : AnnotationSpec() {

    val ingressoClient = mockk<IngressoClientPort>()
    val ingressoServiceImp = IngressoServiceImp(ingressoClient)

    lateinit var ingresso: Ingresso
    lateinit var id: String

    @BeforeEach
    fun setUp() {
        ingresso = Ingresso(
            UUID.randomUUID(),
            "Ingresso Teste Kotest",
            BigDecimal(100.00),
            "Endereço 1",
            LocalDate.now()
        )

        id = "3275ddab-b95a-4ece-a5ab-e9ec220987a5"
    }

    @Test
    fun `cadastrar ingresso`() {
        every { ingressoClient.cadastrar(any()) } answers { Unit }
        val result = ingressoServiceImp.cadastrar(ingresso)
        result shouldBe Unit
    }

    @Test
    fun `atualizar ingresso`() {
        every { ingressoClient.atualizar(any()) } answers { Unit }
        val result = ingressoServiceImp.atualizar(id,ingresso)
        result shouldBe Unit
    }

    @Test
    fun `deletar ingresso`() {
        every { ingressoClient.deletar(any()) } answers { Unit }
        val result = ingressoServiceImp.deletar(id)
        result shouldBe Unit
    }
}