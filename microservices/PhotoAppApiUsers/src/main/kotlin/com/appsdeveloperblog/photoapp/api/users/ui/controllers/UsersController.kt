package com.appsdeveloperblog.photoapp.api.users.ui.controllers

import com.appsdeveloperblog.photoapp.api.users.ui.model.CreateUserRequestModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UsersController {

    @Autowired
    private lateinit var env:Environment

    @GetMapping("/status/check")
    fun status():String {
        return "Working on port ${env.getProperty("local.server.port")}"
    }

    @PostMapping
    fun createUser(@RequestBody users:CreateUserRequestModel):String {
        return "Create user method is called"
    }

}