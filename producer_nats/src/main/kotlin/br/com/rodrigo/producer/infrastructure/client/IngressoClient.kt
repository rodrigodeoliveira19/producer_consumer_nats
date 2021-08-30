package br.com.rodrigo.producer.infrastructure.client

import br.com.rodrigo.producer.core.model.Ingresso
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject
import java.util.*

@NatsClient
interface IngressoClient {

    @Subject("post_ingresso")
    fun cadastrar(@Body ingresso: Ingresso)

    @Subject("put_ingresso")
    fun atualizar(ingresso: Pair<UUID, Ingresso>)

    @Subject("delete_ingresso")
    fun deletar(id: UUID)
}