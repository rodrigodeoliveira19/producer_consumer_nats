package br.com.rodrigo.producer.core.service

import br.com.rodrigo.producer.core.model.Ingresso
import br.com.rodrigo.producer.core.ports.IngressoClientPort
import br.com.rodrigo.producer.core.ports.IngressoServicePort
import jakarta.inject.Singleton
import java.util.*


@Singleton
class IngressoServiceImp(private val ingressoClient: IngressoClientPort) : IngressoServicePort {

    override fun cadastrar(ingresso: Ingresso){
        ingressoClient.cadastrar(ingresso)
    }

    override fun atualizar(id: String, ingresso: Ingresso) {
        ingressoClient.atualizar(Pair(UUID.fromString(id),ingresso))
    }

    override fun deletar(id: String) {
        ingressoClient.deletar(UUID.fromString(id))
    }

}