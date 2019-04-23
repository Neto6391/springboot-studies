package mathapp.exception

import java.io.Serializable
import java.util.*

class ExceptionResponse(
        private var timestamp: Date,
        private var message: String?,
        private var details: String
): Serializable {
    companion object {
        @Transient private const val serialVersionUID = 1L
    }
}