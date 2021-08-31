package br.com.rodrigo.producer.infrastructure.client

import br.com.rodrigo.producer.core.model.IngressoEvent
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject
import java.util.*

@NatsClient
interface IngressoClient {

    @Subject("post_ingresso")
    fun cadastrar(@Body ingressoEvent: IngressoEvent)

    @Subject("put_ingresso")
    fun atualizar(ingressoEvent: Pair<UUID, IngressoEvent>)

    @Subject("delete_ingresso")
    fun deletar(id: UUID)
}