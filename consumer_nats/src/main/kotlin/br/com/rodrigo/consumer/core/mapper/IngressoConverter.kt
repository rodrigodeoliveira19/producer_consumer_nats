package br.com.rodrigo.consumer.core.mapper

import br.com.rodrigo.consumer.core.model.Ingresso
import br.com.rodrigo.consumer.database.model.IngressoEntity
import br.com.rodrigo.consumer.infrastructure.model.IngressoEvent

class IngressoConverter {

    companion object {
        fun ingressoEventToIngresso(ingressoEvent: IngressoEvent) =
            Ingresso(
                descricao = ingressoEvent.descricao, valor = ingressoEvent.valor,
                endereco = ingressoEvent.endereco, dataEvento = ingressoEvent.dataEvento
            )

        fun ingressoToIngressoEntity(ingresso: Ingresso) =
            IngressoEntity(
                descricao = ingresso.descricao, valor = ingresso.valor,
                endereco = ingresso.endereco, dataEvento = ingresso.dataEvento
            )
    }
}