package br.com.rodrigo.engine

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.rodrigo.engine")
		.start()
}

