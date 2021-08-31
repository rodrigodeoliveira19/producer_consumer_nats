package br.com.rodrigo.producer.infrastructure.service

import br.com.rodrigo.producer.core.model.Ingresso
import br.com.rodrigo.producer.core.model.IngressoEvent
import br.com.rodrigo.producer.core.ports.IngressoClientPort
import br.com.rodrigo.producer.infrastructure.client.IngressoClient
import jakarta.inject.Singleton
import java.util.*

@Singleton
class IngressoClientImp(private val ingressoClient: IngressoClient) : IngressoClientPort{

    override fun cadastrar(ingresso: IngressoEvent) {
        ingressoClient.cadastrar(ingresso)
    }

    override fun atualizar(ingresso: Pair<UUID, IngressoEvent>) {
        ingressoClient.atualizar(ingresso)
    }

    override fun deletar(id: UUID) {
        ingressoClient.deletar(id)
    }
}