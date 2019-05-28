package com.appsdeveloperblog.PhotoAppDiscoveryService.discovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class PhotoAppDiscoveryServiceApplication

fun main(args: Array<String>) {
	runApplication<PhotoAppDiscoveryServiceApplication>(*args)
}
