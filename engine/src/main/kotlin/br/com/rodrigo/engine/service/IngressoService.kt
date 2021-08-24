package br.com.rodrigo.engine.service

import br.com.rodrigo.engine.model.Ingresso


interface IngressoService {

    fun buscarTodos(): List<Ingresso>

    fun buscarPorId(id: String): Ingresso?
}