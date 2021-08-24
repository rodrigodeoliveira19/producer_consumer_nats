package br.com.rodrigo.producer.service

import br.com.rodrigo.producer.model.Ingresso

interface IngressoService {

    fun cadastrar(ingresso: Ingresso)

    fun atualizar(id: String, ingresso: Ingresso)

    fun deletar(id: String)
}