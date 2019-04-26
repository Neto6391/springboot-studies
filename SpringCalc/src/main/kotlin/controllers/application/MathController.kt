package controllers.application

import exception.handler.ControllerAdviceRequestError
import application.exception.UnsupportedMathOperationException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import services.application.CalcMathServices
import kotlin.math.abs

@RestController
@ComponentScan("services.application")
class MathController : ControllerAdviceRequestError() {

	@Autowired
	lateinit private var services:CalcMathServices

	@RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"], method = arrayOf(RequestMethod.GET))
	fun sum(@PathVariable(value="numberOne")  numberOne:String, @PathVariable(value="numberTwo")  numberTwo:String):Double {
			if(!services.isNumeric(numberOne) || !services.isNumeric(numberTwo)) {
				throw UnsupportedMathOperationException("Please Set a Numeric Value")
			}
			return services.sumNumbers(numberOne, numberTwo)
	}

	@RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"], method = arrayOf(RequestMethod.GET))
	fun subtraction(@PathVariable(value="numberOne")  numberOne:String, @PathVariable(value="numberTwo")  numberTwo:String):Double {
		if(!services.isNumeric(numberOne) || !services.isNumeric(numberTwo)) {
			throw UnsupportedMathOperationException("Please Set a Numeric Value")
		}
		return abs(services.subtractNumbers(numberOne, numberTwo))
	}

	@RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"], method = arrayOf(RequestMethod.GET))
	fun multiplication(@PathVariable(value="numberOne")  numberOne:String, @PathVariable(value="numberTwo")  numberTwo:String):Double {
		if(!services.isNumeric(numberOne) || !services.isNumeric(numberTwo)) {
			throw UnsupportedMathOperationException("Please Set a Numeric Value")
		}
		return services.multiplyNumbers(numberOne, numberTwo)
	}

	@RequestMapping(value = ["/division/{numberOne}/{numberTwo}"], method = arrayOf(RequestMethod.GET))
	fun division(@PathVariable(value="numberOne")  numberOne:String, @PathVariable(value="numberTwo")  numberTwo:String):Double {
		if(!services.isNumeric(numberOne) || !services.isNumeric(numberTwo)) {
			throw UnsupportedMathOperationException("Please Set a Numeric Value")
		}
		return services.divideNumbers(numberOne, numberTwo)
	}

	@RequestMapping(value = ["/average/{numberOne}/{numberTwo}"], method = arrayOf(RequestMethod.GET))
	fun average(@PathVariable(value="numberOne")  numberOne:String, @PathVariable(value="numberTwo")  numberTwo:String):Double {
		if(!services.isNumeric(numberOne) || !services.isNumeric(numberTwo)) {
			throw UnsupportedMathOperationException("Please Set a Numeric Value")
		}
		return services.averageNumbers(numberOne, numberTwo)
	}

	@RequestMapping(value = ["/squareroot/{numberOne}"], method = arrayOf(RequestMethod.GET))
	fun squareroot(@PathVariable(value="numberOne")  numberOne:String):Double {
		if(!services.isNumeric(numberOne)) {
			throw UnsupportedMathOperationException("Please Set a Numeric Value")
		}
		return services.squareRootNumbers(numberOne)
	}
}

