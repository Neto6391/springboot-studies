package com.appsdeveloperblog.photoapp.api.account

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class PhotoApiAccountManagementApplication

fun main(args: Array<String>) {
	runApplication<PhotoApiAccountManagementApplication>(*args)
}
