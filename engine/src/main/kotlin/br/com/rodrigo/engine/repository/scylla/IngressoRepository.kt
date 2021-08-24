package br.com.rodrigo.engine.repository.scylla


import br.com.rodrigo.engine.model.Ingresso
import java.util.*

interface IngressoRepository {

    fun buscarTodos(): List<Ingresso>

    fun buscarPorId(id: UUID): Ingresso?
}