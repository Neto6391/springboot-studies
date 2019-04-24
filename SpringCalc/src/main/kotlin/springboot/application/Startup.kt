package springboot.application

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import controllers.application.MathController

@SpringBootApplication
class Startup : MathController()

	fun main(args: Array<String>) {
		SpringApplication.run(Startup::class.java, *args)
	}

