package com.neto6391.restappdb.exceptions.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException(override val message:String?): Exception(message)