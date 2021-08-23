package br.com.zup.rodrigo.repository.scylla


import br.com.rodrigo.consumer.model.Ingresso
import java.util.*

interface IngressoRepository {

    fun cadastrar(ingresso: Ingresso)

    fun atualizar(id: UUID,ingresso: Ingresso)

    fun deletar(id: UUID)
}