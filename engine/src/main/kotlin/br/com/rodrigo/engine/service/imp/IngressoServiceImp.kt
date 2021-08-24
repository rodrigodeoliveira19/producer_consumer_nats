package br.com.rodrigo.engine.service.imp


import br.com.rodrigo.engine.model.Ingresso
import br.com.rodrigo.engine.service.IngressoService
import br.com.rodrigo.engine.repository.scylla.IngressoRepository

import jakarta.inject.Singleton
import java.util.*


@Singleton
class IngressoServiceImp(private val ingressoRepository: IngressoRepository) : IngressoService {

    override fun buscarTodos(): List<Ingresso> {
        return ingressoRepository.buscarTodos()
    }

    override fun buscarPorId(id: String): Ingresso? {
        return ingressoRepository.buscarPorId(UUID.fromString(id))
    }
}