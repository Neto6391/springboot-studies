package com.neto6391.loginapp

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
class Startup : SpringBootServletInitializer() {

	protected override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
		return application.sources(Startup::class.java!!)
	}
}
	fun main(args: Array<String>) {
		runApplication<Startup>(*args)
	}