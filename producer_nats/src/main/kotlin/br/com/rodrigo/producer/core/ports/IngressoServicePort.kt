package br.com.rodrigo.producer.core.ports

import br.com.rodrigo.producer.core.model.Ingresso

interface IngressoServicePort {

    fun cadastrar(ingresso: Ingresso)

    fun atualizar(id: String, ingresso: Ingresso)

    fun deletar(id: String)
}