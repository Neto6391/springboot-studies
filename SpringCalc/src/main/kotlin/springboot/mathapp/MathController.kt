package springboot.mathapp

import exception.handler.ControllerAdviceRequestError
import mathapp.exception.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController : ControllerAdviceRequestError() {


	@RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"], method = arrayOf(RequestMethod.GET))
	fun sum(@PathVariable(value="numberOne")  numberOne:String, @PathVariable(value="numberTwo")  numberTwo:String):Double {
			if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
				throw UnsupportedMathOperationException("Please Set a Numeric Value")
			}
			val sum: Double = convertToDouble(numberOne) + convertToDouble(numberTwo)
			return sum
	}
		
	private fun isNumeric(strNumber:String):Boolean {
		if(strNumber == null) return false
		val number:String = strNumber.replace(",", ".")
		return number.matches(Regex("[-+]?[0-9]*\\.?[0-9]+"))

	}
	
	private fun convertToDouble(strNumber:String):Double {
		if(strNumber == null) return 0.0
		val number:String = strNumber.replace(",", ".")
		if(isNumeric(number)) return number.toDouble()
		return 0.0
	}
	
	
}

