package com.neto6391.restappdb

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
//Permit Application Content be automatically load basead in Jars and configurations defined. always is done after beans is registred in App Content.
@EnableAutoConfiguration
//Scan Packages and Found Files of Config
@ComponentScan
class Startup

	fun main(args: Array<String>) {
		SpringApplication.run(Startup::class.java, *args)
	}