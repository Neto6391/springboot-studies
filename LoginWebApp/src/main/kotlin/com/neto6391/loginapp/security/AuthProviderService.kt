package com.neto6391.loginapp.security

import com.neto6391.loginapp.repositories.RoleRepository
import com.neto6391.loginapp.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import java.util.stream.Collectors
import javax.management.relation.Role

@Component
class AuthProviderService (
        private val encoder:BCryptPasswordEncoder
) : AuthenticationProvider {


    @Autowired private val userRepository:UserRepository? = null

    override fun authenticate(auth: Authentication): Authentication {
        val username = auth.name
        val password = auth.credentials.toString()



        val user = userRepository!!.findByUsername(username)
        val authorities = user!!.getRoles()!!.stream().map {r ->
            SimpleGrantedAuthority(r.getName())
        }.collect(Collectors.toList())

        if (encoder.matches(password, user.getPassword())) {
            return UsernamePasswordAuthenticationToken(username, password, authorities)
        } else {
            throw BadCredentialsException("Authentication failed")
        }
    }

    override fun supports(auth: Class<*>): Boolean {
        return auth == UsernamePasswordAuthenticationToken::class.java
    }


}