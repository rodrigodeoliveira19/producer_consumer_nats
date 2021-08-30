package br.com.rodrigo.producer.core.mapper

import br.com.rodrigo.producer.core.model.Ingresso
import br.com.rodrigo.producer.entrypoint.model.IngressoRequest

class IngressoConverter {

    companion object {

        fun ingressoRequestToIngresso(ingressoRequest: IngressoRequest) =
            Ingresso(
                descricao = ingressoRequest.descricao, valor = ingressoRequest.valor,
                endereco = ingressoRequest.endereco, dataEvento = ingressoRequest.dataEvento
            )

    }
}