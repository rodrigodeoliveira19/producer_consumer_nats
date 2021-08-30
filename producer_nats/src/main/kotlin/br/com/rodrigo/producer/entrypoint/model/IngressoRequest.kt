package br.com.rodrigo.producer.entrypoint.model


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

}
