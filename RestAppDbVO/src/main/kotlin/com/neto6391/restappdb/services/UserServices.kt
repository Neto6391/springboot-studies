package com.neto6391.restappdb.services

import com.neto6391.restappdb.repositories.UserRespository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserServices(private val repository: UserRespository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails{
        val user = repository.findByUsername(username)
        if(user != null) {
            return user
        } else {
            throw UsernameNotFoundException("Username $username not found")
        }

    }


}