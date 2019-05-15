package com.neto6391.loginapp.services

import com.neto6391.loginapp.data.model.User
import com.neto6391.loginapp.data.vo.UserVO

interface UserService {
    fun save(user:User?)
    fun findByUsername(username:String?):User?
}