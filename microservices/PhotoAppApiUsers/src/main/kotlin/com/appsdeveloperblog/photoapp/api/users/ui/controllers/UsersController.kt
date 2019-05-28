package com.appsdeveloperblog.photoapp.api.users.ui.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController {

    @GetMapping("/status/check")
    fun status():String {
        return "Working"
    }

}