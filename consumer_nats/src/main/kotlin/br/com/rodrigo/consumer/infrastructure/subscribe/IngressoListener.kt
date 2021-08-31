package br.com.rodrigo.consumer.infrastructure.subscribe

import br.com.rodrigo.consumer.core.mapper.IngressoConverter
import br.com.rodrigo.consumer.core.ports.IngressoServicePort
import br.com.rodrigo.consumer.infrastructure.model.IngressoEvent
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.PathVariable
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import java.util.*

@NatsListener
class IngressoListener(private val ingressoService: IngressoServicePort){

    @Subject("post_ingresso")
    fun cadastrar(@Body ingresso: IngressoEvent){
        ingressoService.cadastrar(IngressoConverter.ingressoEventToIngresso(ingresso))
    }

    @Subject("put_ingresso")
    fun atualizar(ingresso : Pair<UUID, IngressoEvent>){
        ingressoService.atualizar(ingresso.first, IngressoConverter.ingressoEventToIngresso(ingresso.second))
    }

    @Subject("delete_ingresso")
    fun delete(@PathVariable id: UUID){
        ingressoService.deletar(id)
    }
}