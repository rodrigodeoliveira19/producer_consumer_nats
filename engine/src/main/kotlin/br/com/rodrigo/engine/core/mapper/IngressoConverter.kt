package br.com.rodrigo.engine.core.mapper

import br.com.rodrigo.engine.database.model.IngressoEntity
import br.com.rodrigo.engine.entrypoint.model.IngressoResponse

class IngressoConverter {

    companion object {

        fun ingressoEntityListToIngressoResponseList(ingressos: List<IngressoEntity>): List<IngressoResponse> {
            return ingressos.map {
                IngressoResponse(
                    id = it.id,
                    descricao = it.descricao,
                    valor = it.valor,
                    endereco = it.endereco,
                    dataEvento = it.dataEvento
                )
            }
        }

        fun ingressoEntityToIngressoResponse(ingresso: IngressoEntity) =
            IngressoResponse(
                id = ingresso.id, descricao = ingresso.descricao, valor = ingresso.valor,
                endereco = ingresso.endereco, dataEvento = ingresso.dataEvento
            )
    }
}