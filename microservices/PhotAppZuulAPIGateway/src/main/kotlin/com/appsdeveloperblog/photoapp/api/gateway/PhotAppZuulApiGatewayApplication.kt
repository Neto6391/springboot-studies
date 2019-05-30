package com.appsdeveloperblog.photoapp.api.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PhotAppZuulApiGatewayApplication

fun main(args: Array<String>) {
	runApplication<PhotAppZuulApiGatewayApplication>(*args)
}
