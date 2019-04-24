package controllers.application

import exception.handler.ControllerAdviceRequestError
import application.exception.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import number.utils.Number
import kotlin.math.abs

@RestController
class MathController : ControllerAdviceRequestError() {

	private var numbers = Number()

	@RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"], method = arrayOf(RequestMethod.GET))
	fun sum(@PathVariable(value="numberOne")  numberOne:String, @PathVariable(value="numberTwo")  numberTwo:String):Double {
			this.numbers.setNumbers(numberOne, numberTwo)
			if(!numbers.isNumeric(numberOne) || !numbers.isNumeric(numberTwo)) {
				throw UnsupportedMathOperationException("Please Set a Numeric Value")
			}
			return numbers.sumNumbers(numbers.numberOne, numbers.numberTwo)
	}

	@RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"], method = arrayOf(RequestMethod.GET))
	fun subtraction(@PathVariable(value="numberOne")  numberOne:String, @PathVariable(value="numberTwo")  numberTwo:String):Double {
		this.numbers.setNumbers(numberOne, numberTwo)
		if(!numbers.isNumeric(numberOne) || !numbers.isNumeric(numberTwo)) {
			throw UnsupportedMathOperationException("Please Set a Numeric Value")
		}
		return abs(numbers.subtractNumbers(numbers.numberOne, numbers.numberTwo))
	}

	@RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"], method = arrayOf(RequestMethod.GET))
	fun multiplication(@PathVariable(value="numberOne")  numberOne:String, @PathVariable(value="numberTwo")  numberTwo:String):Double {
		this.numbers.setNumbers(numberOne, numberTwo)
		if(!numbers.isNumeric(numberOne) || !numbers.isNumeric(numberTwo)) {
			throw UnsupportedMathOperationException("Please Set a Numeric Value")
		}
		return numbers.multiplyNumbers(numbers.numberOne, numbers.numberTwo)
	}

	@RequestMapping(value = ["/division/{numberOne}/{numberTwo}"], method = arrayOf(RequestMethod.GET))
	fun division(@PathVariable(value="numberOne")  numberOne:String, @PathVariable(value="numberTwo")  numberTwo:String):Double {
		this.numbers.setNumbers(numberOne, numberTwo)
		if(!numbers.isNumeric(numberOne) || !numbers.isNumeric(numberTwo)) {
			throw UnsupportedMathOperationException("Please Set a Numeric Value")
		}
		return numbers.divideNumbers(numbers.numberOne, numbers.numberTwo)
	}

	@RequestMapping(value = ["/average/{numberOne}/{numberTwo}"], method = arrayOf(RequestMethod.GET))
	fun average(@PathVariable(value="numberOne")  numberOne:String, @PathVariable(value="numberTwo")  numberTwo:String):Double {
		this.numbers.setNumbers(numberOne, numberTwo)
		if(!numbers.isNumeric(numberOne) || !numbers.isNumeric(numberTwo)) {
			throw UnsupportedMathOperationException("Please Set a Numeric Value")
		}
		return numbers.averageNumbers(numbers.numberOne, numbers.numberTwo)
	}

	@RequestMapping(value = ["/squareroot/{numberOne}"], method = arrayOf(RequestMethod.GET))
	fun squareroot(@PathVariable(value="numberOne")  numberOne:String):Double {
		this.numbers.setOnlyNumberOne(numberOne)
		if(!numbers.isNumeric(numberOne)) {
			throw UnsupportedMathOperationException("Please Set a Numeric Value")
		}
		return numbers.squareRootNumbers(numbers.numberOne)
	}
}

