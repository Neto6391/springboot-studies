package exception.handler

import mathapp.exception.ExceptionResponse
import mathapp.exception.UnsupportedMathOperationException
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
    fun handleAllExceptions(ex:UnsupportedMathOperationException, request:WebRequest) : ResponseEntity<ExceptionResponse>{
        val exceptionResponse = ExceptionResponse(
                Date(),
                ex.message,
                request.getDescription(false)
        )
        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [(UnsupportedMathOperationException::class)])
    fun handleBadRequestExceptions(ex:UnsupportedMathOperationException, request:WebRequest) : ResponseEntity<ExceptionResponse>{
        val exceptionResponse = ExceptionResponse(
                Date(),
                ex.message,
                request.getDescription(false)
        )
        return ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST)
    }

}