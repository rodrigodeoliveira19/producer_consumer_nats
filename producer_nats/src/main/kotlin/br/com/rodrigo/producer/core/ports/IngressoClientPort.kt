package br.com.rodrigo.producer.core.ports

import br.com.rodrigo.producer.core.model.Ingresso
import java.util.*

interface IngressoClientPort {

    fun cadastrar(ingresso: Ingresso)

    fun atualizar(ingresso: Pair<UUID, Ingresso>)

    fun deletar(id: UUID)
}