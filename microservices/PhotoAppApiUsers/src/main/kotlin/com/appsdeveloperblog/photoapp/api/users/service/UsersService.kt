package com.appsdeveloperblog.photoapp.api.users.service

import com.appsdeveloperblog.photoapp.api.users.shared.UserDto

interface UsersService {
    fun createUsers(userDetails:UserDto): UserDto?
}