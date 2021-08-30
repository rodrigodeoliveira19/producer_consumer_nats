package br.com.rodrigo.producer.entrypoint.inbound

import br.com.rodrigo.producer.core.mapper.IngressoConverter
import br.com.rodrigo.producer.entrypoint.model.IngressoRequest
import br.com.rodrigo.producer.core.ports.IngressoServicePort
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/ingressos")
class IngressoController(private val ingressoService: IngressoServicePort) {

    @Post
    fun cadastrar(@Body @Valid ingressoRequest: IngressoRequest): HttpResponse<Any> {
        ingressoService.cadastrar(IngressoConverter.ingressoRequestToIngresso(ingressoRequest))
        return HttpResponse.ok()
    }

    @Put("/{id}")
    fun atualizar(@PathVariable id: String, @Body @Valid ingressoRequest: IngressoRequest)
            : HttpResponse<Any> {
        
        ingressoService.atualizar(id, IngressoConverter.ingressoRequestToIngresso(ingressoRequest))
        return HttpResponse.ok()
    }

    @Delete("/{id}")
    fun deletar(@PathVariable id: String): HttpResponse<Unit> {
        ingressoService.deletar(id)
        return HttpResponse.ok()
    }
}