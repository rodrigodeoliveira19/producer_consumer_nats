package br.com.rodrigo.producer

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.rodrigo.producer")
		.start()
}

