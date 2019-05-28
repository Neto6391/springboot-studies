package com.appsdeveloperblog.photoapp.api.users

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class PhotoAppApiUsersApplication

fun main(args: Array<String>) {
	runApplication<PhotoAppApiUsersApplication>(*args)
}
