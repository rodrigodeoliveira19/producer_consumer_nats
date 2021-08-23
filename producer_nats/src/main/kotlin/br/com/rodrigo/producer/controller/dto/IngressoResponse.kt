package br.com.zup.rodrigo.dto

import br.com.zup.rodrigo.model.Ingresso

class IngressoResponse(ingresso: Ingresso) {

    val descricao = ingresso.descricao
    val valor = ingresso.valor
    val endereco = ingresso.endereco
    val dataEvento = ingresso.dataEvento
    val id = ingresso.id
}
