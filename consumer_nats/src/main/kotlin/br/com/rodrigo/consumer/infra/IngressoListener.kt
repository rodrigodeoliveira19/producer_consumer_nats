package br.com.rodrigo.consumer.infra

import br.com.rodrigo.consumer.model.Ingresso
import br.com.rodrigo.consumer.service.IngressoService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.PathVariable
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import java.util.*

@NatsListener
class IngressoListener(private val ingressoService: IngressoService){

    @Subject("post_ingresso")
    fun cadastrar(@Body ingresso: Ingresso){
        ingressoService.cadastrar(ingresso)
    }

    @Subject("put_ingresso")
    fun atualizar(ingresso : Pair<UUID,Ingresso>){
        ingressoService.atualizar(ingresso.first, ingresso.second)
    }

    @Subject("delete_ingresso")
    fun delete(@PathVariable id: UUID){
        ingressoService.deletar(id)
    }
}