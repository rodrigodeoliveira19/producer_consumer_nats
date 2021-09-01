package br.com.rodrigo.engine.entrypoint.inbound


import br.com.rodrigo.engine.core.ports.IngressoServicePort
import br.com.rodrigo.engine.entrypoint.model.IngressoResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.validation.Validated

@Validated
@Controller("/ingressos")
class IngressoController(private val ingressoService: IngressoServicePort) {

    @Get
    fun buscarTodos(): HttpResponse<List<IngressoResponse>> {
        
        return HttpResponse.ok(ingressoService.buscarTodos())
    }

    @Get("/{id}")
    fun buscarPorId(@PathVariable id: String): HttpResponse<IngressoResponse> {
        val ingressoResponse = ingressoService.buscarPorId(id)
        if (ingressoResponse == null) {
            return HttpResponse.notFound()
        }

        return HttpResponse.ok(ingressoResponse)
    }

}