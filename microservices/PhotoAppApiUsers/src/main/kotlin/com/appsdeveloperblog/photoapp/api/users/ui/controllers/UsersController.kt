package com.appsdeveloperblog.photoapp.api.users.ui.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController {

    @Autowired
    private lateinit var env:Environment

    @GetMapping("/status/check")
    fun status():String {
        return "Working on port ${env.getProperty("local.server.port")}"
    }

}