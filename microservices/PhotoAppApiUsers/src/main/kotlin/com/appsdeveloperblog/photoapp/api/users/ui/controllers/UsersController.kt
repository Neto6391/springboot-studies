package com.appsdeveloperblog.photoapp.api.users.ui.controllers

import com.appsdeveloperblog.photoapp.api.users.service.UsersService
import com.appsdeveloperblog.photoapp.api.users.shared.UserDto
import com.appsdeveloperblog.photoapp.api.users.ui.model.CreateUserRequestModel
import com.appsdeveloperblog.photoapp.api.users.ui.model.CreateUserResponseModel
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun createUser(@Valid @RequestBody usersDetails:CreateUserRequestModel):ResponseEntity<CreateUserResponseModel> {

        val modelMapper = ModelMapper()
        modelMapper.configuration.matchingStrategy = MatchingStrategies.STRICT

        val userDto = modelMapper.map(usersDetails, UserDto::class.java)
        val createdUser = usersService.createUsers(userDto)

        val returnValue = modelMapper.map(createdUser, CreateUserResponseModel::class.java)

        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue)
    }

}