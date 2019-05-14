package com.neto6391.restappdb.controllers.v1

import com.neto6391.restappdb.repositories.UserRespository
import com.neto6391.restappdb.data.vo.v1.AccountCredentialsVO
import com.neto6391.restappdb.security.jwt.JwtTokenProvider
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
        val authenticationManager: AuthenticationManager,
        val tokenProvider: JwtTokenProvider,
        val repository:UserRespository
) {

    @ApiOperation(value = "Authenticate a user by credentials")
    @PostMapping(
            value = "/signin",
            produces = ["application/json", "application/xml", "application/x-yaml"],
            consumes = ["application/json", "application/xml", "application/x-yaml"]
    )
    fun signin(@RequestBody data: AccountCredentialsVO): ResponseEntity<*> {
        try {
            val username = data.username
            val password = data.password

            var user = repository.findByUsername(username)
            var token = ""

            if(user != null) {
                token = tokenProvider.createToken(username, user.getRoles())
            } else {
                throw UsernameNotFoundException("Username $username not found!")
            }

            val model =  HashMap<Any,Any>()
            model.put("username", username)
            model.put("token", token)
            return ok(model)
        } catch (e:Exception) {
            throw BadCredentialsException("Invalid Username username/Password supplied")
        }
    }

}