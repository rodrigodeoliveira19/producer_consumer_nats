package br.com.rodrigo.producer.core.ports

import br.com.rodrigo.producer.core.model.IngressoEvent
import java.util.*

interface IngressoClientPort {

    fun cadastrar(ingressoEnvent: IngressoEvent)

    fun atualizar(ingresso: Pair<UUID, IngressoEvent>)

    fun deletar(id: UUID)
}