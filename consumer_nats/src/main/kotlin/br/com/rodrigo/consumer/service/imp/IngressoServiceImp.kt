package br.com.rodrigo.consumer.service.imp


import br.com.rodrigo.consumer.model.Ingresso
import br.com.rodrigo.consumer.service.IngressoService
import br.com.rodrigo.consumer.repository.scylla.IngressoRepository

import jakarta.inject.Singleton
import java.util.*


@Singleton
class IngressoServiceImp(private val ingressoRepository: IngressoRepository) : IngressoService {

    override fun cadastrar(ingresso: Ingresso){
        ingressoRepository.cadastrar(ingresso)
    }

    override fun atualizar(id: UUID, ingresso: Ingresso) {
        ingressoRepository.atualizar(id,ingresso)
    }

    override fun deletar(id: UUID) {
        ingressoRepository.deletar(id)
    }
}