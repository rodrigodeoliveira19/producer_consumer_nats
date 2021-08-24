package br.com.rodrigo.producer.controller

import br.com.rodrigo.producer.controller.dto.IngressoRequest
import br.com.rodrigo.producer.service.IngressoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/ingressos")
class IngressoController(private val ingressoService: IngressoService) {

    @Post
    fun cadastrar(@Body @Valid ingressoRequest: IngressoRequest): HttpResponse<Any> {
        val ingresso = ingressoRequest.ToModel()
        ingressoService.cadastrar(ingresso)
        return HttpResponse.ok()
    }

    @Put("/{id}")
    fun atualizar(@PathVariable id: String, @Body @Valid ingressoRequest: IngressoRequest)
            : HttpResponse<Any> {

        val ingresso = ingressoRequest.ToModel()
        ingressoService.atualizar(id, ingresso)
        return HttpResponse.ok()
    }

    @Delete("/{id}")
    fun deletar(@PathVariable id: String): HttpResponse<Unit> {
        ingressoService.deletar(id)
        return HttpResponse.ok()
    }
}