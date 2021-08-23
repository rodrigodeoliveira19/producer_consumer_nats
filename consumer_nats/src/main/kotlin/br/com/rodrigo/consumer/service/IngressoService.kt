package br.com.rodrigo.consumer.service

import br.com.rodrigo.consumer.model.Ingresso
import java.util.*


interface IngressoService {

    fun cadastrar(ingresso: Ingresso)

    fun atualizar(id: UUID, ingresso: Ingresso)

    fun deletar(id: UUID)
}