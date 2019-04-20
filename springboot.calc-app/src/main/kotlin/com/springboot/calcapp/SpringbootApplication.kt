package com.springboot.calcapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SpringbootApplication

fun main(args: Array<String>) {
	runApplication<SpringbootApplication>(*args)
	println("Hello World")
}
