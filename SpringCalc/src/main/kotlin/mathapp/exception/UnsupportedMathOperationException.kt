package mathapp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.BAD_REQUEST)
class UnsupportedMathOperationException(override val message:String?): Exception(message)