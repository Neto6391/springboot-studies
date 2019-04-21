package com.spring.calc.SpringCalc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
open class SpringcalcApplication {

	fun main(args: Array<String>) {
		SpringApplication.run(SpringcalcApplication::class.java, *args) 
	}

}