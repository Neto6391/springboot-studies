package com.neto6391.loginapp.repositories

import com.neto6391.loginapp.data.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String?): User?
}