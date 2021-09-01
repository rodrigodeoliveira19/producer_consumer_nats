package br.com.rodrigo.engine.core.service


import br.com.rodrigo.engine.core.mapper.IngressoConverter
import br.com.rodrigo.engine.core.model.Ingresso
import br.com.rodrigo.engine.core.ports.IngressoServicePort
import br.com.rodrigo.engine.core.ports.IngressoRepository
import br.com.rodrigo.engine.entrypoint.model.IngressoResponse

import jakarta.inject.Singleton
import java.util.*


@Singleton
class IngressoServiceImp(private val ingressoRepository: IngressoRepository) : IngressoServicePort {

    override fun buscarTodos(): List<IngressoResponse> {

        return IngressoConverter.ingressoEntityListToIngressoResponseList(ingressoRepository.buscarTodos())
    }

    override fun buscarPorId(id: String): IngressoResponse? {
        return ingressoRepository.buscarPorId(UUID.fromString(id))
            ?.let { IngressoConverter.ingressoEntityToIngressoResponse(it) }
    }
}