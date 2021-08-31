package br.com.rodrigo.consumer.core.service


import br.com.rodrigo.consumer.core.mapper.IngressoConverter
import br.com.rodrigo.consumer.core.model.Ingresso
import br.com.rodrigo.consumer.core.ports.IngressoServicePort
import br.com.rodrigo.consumer.core.ports.IngressoRepositoryPort

import jakarta.inject.Singleton
import java.util.*


@Singleton
class IngressoServiceImp(private val ingressoRepository: IngressoRepositoryPort) : IngressoServicePort {

    override fun cadastrar(ingresso: Ingresso){
        ingressoRepository.cadastrar(IngressoConverter.ingressoToIngressoEntity(ingresso))
    }

    override fun atualizar(id: UUID, ingresso: Ingresso) {
        ingressoRepository.atualizar(id,IngressoConverter.ingressoToIngressoEntity(ingresso))
    }

    override fun deletar(id: UUID) {
        ingressoRepository.deletar(id)
    }
}