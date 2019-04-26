package com.neto6391.restappdb

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import com.neto6391.restappdb.controllers.PersonController
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication

class Startup

	fun main(args: Array<String>) {
		SpringApplication.run(Startup::class.java, *args)
	}