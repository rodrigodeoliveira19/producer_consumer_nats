package br.com.rodrigo.consumer.core.ports


import br.com.rodrigo.consumer.database.model.IngressoEntity
import java.util.*

interface IngressoRepositoryPort {

    fun cadastrar(ingresso: IngressoEntity)

    fun atualizar(id: UUID,ingresso: IngressoEntity)

    fun deletar(id: UUID)
}