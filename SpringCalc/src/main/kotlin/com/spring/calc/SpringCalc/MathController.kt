package com.spring.calc.SpringCalc

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
open class MathController {
	
	
	@RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"], method = arrayOf(RequestMethod.GET))
	public fun sum(@PathVariable(value="numberOne")  numberOne:String, @PathVariable(value="numberTwo")  numberTwo:String) {
		//val result:Double = numberOne.toDouble() + numberTwo.toDouble()
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw Exception()
		}
		val sum:Double = convertToDouble(numberOne) + convertToDouble(numberTwo)
		ResultNumber(sum)
	}
		
	public fun isNumeric(number:String):Boolean {
		return false
	}
	
	public fun convertToDouble(number:String):Double {
		return number.toDouble()
	}
	
	
}