package br.com.rodrigo.producer.controller.dto


import br.com.rodrigo.producer.model.Ingresso
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.convert.format.Format
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Introspected
class IngressoRequest(
    @field: NotBlank val descricao: String,
    @field: Positive val valor: BigDecimal,
    @field: NotBlank val endereco: String,
    @Format("yyyy/MM/dd")
    val dataEvento: LocalDate
) {

    fun ToModel(): Ingresso {
        return Ingresso(
            descricao = descricao,
            valor = valor,
            endereco = endereco,
            dataEvento = dataEvento
        )
    }

}
