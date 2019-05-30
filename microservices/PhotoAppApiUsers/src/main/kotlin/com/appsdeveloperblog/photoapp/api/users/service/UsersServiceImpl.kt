package com.appsdeveloperblog.photoapp.api.users.service

import com.appsdeveloperblog.photoapp.api.users.shared.UserDto
import java.util.*

class UsersServiceImpl : UsersService {
    override fun createUsers(userDetails: UserDto): UserDto? {
        //Generate Random Unique User Id
        userDetails.setUserId(UUID.randomUUID().toString())

        return null
    }

}