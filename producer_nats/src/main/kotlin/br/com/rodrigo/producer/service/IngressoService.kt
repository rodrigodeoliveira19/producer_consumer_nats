package br.com.rodrigo.producer.service

import br.com.zup.rodrigo.model.Ingresso

interface IngressoService {

    fun cadastrar(ingresso: Ingresso)

    fun atualizar(id: String, ingresso: Ingresso)

    fun deletar(id: String)
}