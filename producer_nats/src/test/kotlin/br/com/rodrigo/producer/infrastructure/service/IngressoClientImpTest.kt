package br.com.rodrigo.producer.infrastructure.service

import br.com.rodrigo.producer.core.model.IngressoEvent
import br.com.rodrigo.producer.infrastructure.client.IngressoClient
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@MicronautTest
class IngressoClientImpTest : AnnotationSpec(){

    var ingressoClient = mockk<IngressoClient>()
    var ingressoClientImp = IngressoClientImp(ingressoClient)

    lateinit var ingressoEvent: IngressoEvent
    lateinit var ingresso : Pair<UUID, IngressoEvent>
    lateinit var id: UUID

    @BeforeEach
    fun setUp(){
        ingressoEvent = IngressoEvent(descricao =  "Ingresso Teste Kotest", valor = BigDecimal(100.00),
           endereco =  "Endereço 1", dataEvento = LocalDate.now())
        id = UUID.randomUUID()
        ingresso = Pair(id,ingressoEvent)
    }

    @Test
    fun `cadastrar`(){
        every { ingressoClient.cadastrar(any()) } answers {Unit}
        val result = ingressoClientImp.cadastrar(ingressoEvent)
        result shouldBe Unit
    }

    @Test
    fun `atualizar`(){
        every { ingressoClient.atualizar(any()) } answers {Unit}
        val result = ingressoClientImp.atualizar(ingresso)
        result shouldBe Unit
    }

    @Test
    fun `deletar`(){
        every { ingressoClient.deletar(any()) } answers {Unit}
        val result = ingressoClientImp.deletar(id)
        result shouldBe Unit
    }
}