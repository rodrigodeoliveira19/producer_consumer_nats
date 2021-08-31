package br.com.rodrigo.consumer.core.ports

import br.com.rodrigo.consumer.core.model.Ingresso
import java.util.*


interface IngressoServicePort {

    fun cadastrar(ingresso: Ingresso)

    fun atualizar(id: UUID, ingresso: Ingresso)

    fun deletar(id: UUID)
}