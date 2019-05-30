package com.appsdeveloperblog.photoapp.api.users.service

interface UsersService {
    fun createUsers(userDetails:UserDto):UserDto
}