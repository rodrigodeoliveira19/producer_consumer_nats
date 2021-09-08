package br.com.rodrigo.producer

import br.com.rodrigo.producer.core.model.Ingresso
import br.com.rodrigo.producer.core.service.IngressoServiceImp
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@MicronautTest
class Producer_natsTest(private val ingressoServiceImp: IngressoServiceImp): AnnotationSpec() {

    lateinit var ingresso: Ingresso

    @BeforeEach
    fun init() {
         ingresso = Ingresso(
            UUID.randomUUID(),
            "Descrição",
            BigDecimal(100.00),
            "Endereço 1",
            LocalDate.now()
        )
    }

    @Test
    fun `cadastrar ingresso`(){
        val result = ingressoServiceImp.cadastrar(ingresso)
        result shouldBe Unit
    }

}
