package com.appsdeveloperblog.photoapp.api.users

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
@EnableEurekaClient
class PhotoAppApiUsersApplication

fun main(args: Array<String>) {
	runApplication<PhotoAppApiUsersApplication>(*args)
}

