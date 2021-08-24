package br.com.rodrigo.consumer.repository.scylla


import br.com.rodrigo.consumer.model.Ingresso
import java.util.*

interface IngressoRepository {

    fun cadastrar(ingresso: Ingresso)

    fun atualizar(id: UUID,ingresso: Ingresso)

    fun deletar(id: UUID)
}