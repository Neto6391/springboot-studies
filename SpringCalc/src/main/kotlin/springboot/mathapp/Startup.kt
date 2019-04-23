package springboot.mathapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class Startup

	fun main(args: Array<String>) {
		SpringApplication.run(Startup::class.java, *args)
	}

