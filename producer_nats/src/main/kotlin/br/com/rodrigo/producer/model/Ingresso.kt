package br.com.zup.rodrigo.model

import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive


class Ingresso(
    val id: UUID? = null,
    @field: NotBlank var descricao: String,
    @field: Positive var valor: BigDecimal,
    @field: NotBlank var endereco: String,
    var dataEvento: LocalDate
) {

    fun atualizar(ingresso: Ingresso) {
        descricao = ingresso.descricao
        valor = ingresso.valor
        endereco = ingresso.endereco
        dataEvento = ingresso.dataEvento
    }
}