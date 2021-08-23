package br.com.zup.rodrigo.service.imp

import br.com.rodrigo.producer.infra.IngressoClient
import br.com.rodrigo.producer.service.IngressoService
import br.com.zup.rodrigo.model.Ingresso
import jakarta.inject.Singleton
import java.util.*


@Singleton
class IngressoServiceImp(private val ingressoClient: IngressoClient) : IngressoService {

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