package br.com.rodrigo.engine.controller.dto

import br.com.rodrigo.engine.model.Ingresso

class IngressoResponse(ingresso: Ingresso) {

    val descricao = ingresso.descricao
    val valor = ingresso.valor
    val endereco = ingresso.endereco
    val dataEvento = ingresso.dataEvento
    val id = ingresso.id
}
