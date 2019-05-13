package com.neto6391.restappdb.exceptions.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import javax.security.sasl.AuthenticationException

@ResponseStatus(HttpStatus.BAD_REQUEST)
class InvalidJwtAuthenticationException(val exception:String) : AuthenticationException(exception)