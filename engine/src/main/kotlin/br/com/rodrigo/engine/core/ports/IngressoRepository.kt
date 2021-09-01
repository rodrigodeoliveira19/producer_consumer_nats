package br.com.rodrigo.engine.core.ports


import br.com.rodrigo.engine.database.model.IngressoEntity
import java.util.*

interface IngressoRepository {

    fun buscarTodos(): List<IngressoEntity>

    fun buscarPorId(id: UUID): IngressoEntity?
}