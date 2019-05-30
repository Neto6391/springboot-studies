package com.appsdeveloperblog.photoapp.api.users.ui.controllers

import com.appsdeveloperblog.photoapp.api.users.service.UsersService
import com.appsdeveloperblog.photoapp.api.users.shared.UserDto
import com.appsdeveloperblog.photoapp.api.users.ui.model.CreateUserRequestModel
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UsersController {

    @Autowired
    private lateinit var env:Environment

    @Autowired
    private lateinit var usersService: UsersService

    @GetMapping("/status/check")
    fun status():String {
        return "Working on port ${env.getProperty("local.server.port")}"
    }

    @PostMapping
    fun createUser(@Valid @RequestBody usersDetails:CreateUserRequestModel):String {

        val modelMapper = ModelMapper()
        modelMapper.configuration.matchingStrategy = MatchingStrategies.STRICT

        val userDto = modelMapper.map(usersDetails, UserDto::class.java)
        usersService.createUsers(userDto)

        return "Create user method is called"
    }

}