package br.com.rodrigo.engine.core.ports

import br.com.rodrigo.engine.entrypoint.model.IngressoResponse


interface IngressoServicePort {

    fun buscarTodos(): List<IngressoResponse>

    fun buscarPorId(id: String): IngressoResponse?
}