package com.neto6391.restappdb.exceptions.handler

import com.neto6391.restappdb.exceptions.exception.ExceptionResponse
import com.neto6391.restappdb.exceptions.exception.InvalidJwtAuthenticationException
import com.neto6391.restappdb.exceptions.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*


@ControllerAdvice
class ControllerAdviceRequestError: ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(Exception::class)])
    fun handleAllExceptions(ex: ResourceNotFoundException, request:WebRequest) : ResponseEntity<ExceptionResponse>{
        val exceptionResponse = ExceptionResponse(
                Date(),
                ex.message,
                request.getDescription(false)
        )
        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [(ResourceNotFoundException::class)])
    fun handleBadRequestExceptions(ex: ResourceNotFoundException, request:WebRequest) : ResponseEntity<ExceptionResponse>{
        val exceptionResponse = ExceptionResponse(
                Date(),
                ex.message,
                request.getDescription(false)
        )
        return ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [(InvalidJwtAuthenticationException::class)])
    fun handleInvalidJwtAuthenticationException(ex: ResourceNotFoundException, request:WebRequest) : ResponseEntity<ExceptionResponse>{
        val exceptionResponse = ExceptionResponse(
                Date(),
                ex.message,
                request.getDescription(false)
        )
        return ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST)
    }

}