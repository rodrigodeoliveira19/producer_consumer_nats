package br.com.rodrigo.engine.database.model

import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

class IngressoEntity(
    val id: UUID? = null,
    @field: NotBlank var descricao: String,
    @field: Positive var valor: BigDecimal,
    @field: NotBlank var endereco: String,
    var dataEvento: LocalDate
) {
}