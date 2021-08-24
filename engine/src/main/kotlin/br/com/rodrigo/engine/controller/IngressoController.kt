package br.com.rodrigo.engine.controller


import br.com.rodrigo.engine.controller.dto.IngressoResponse
import br.com.rodrigo.engine.service.IngressoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.validation.Validated

@Validated
@Controller("/ingressos")
class IngressoController(private val ingressoService: IngressoService) {

    @Get
    fun buscarTodos(): HttpResponse<List<IngressoResponse>> {
        val ingressos = ingressoService.buscarTodos()
        val ingressosResponse = ingressos.map { ingresso -> IngressoResponse(ingresso) }
        return HttpResponse.ok(ingressosResponse)
    }

    @Get("/{id}")
    fun buscarPorId(@PathVariable id: String): HttpResponse<IngressoResponse> {
        val ingresso = ingressoService.buscarPorId(id)
        if (ingresso == null) {
            return HttpResponse.notFound()
        }

        return HttpResponse.ok(IngressoResponse(ingresso))
    }

}