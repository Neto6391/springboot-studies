package calc.utils

import utils.converter.ConversionNumber
import kotlin.math.sqrt

open class CalcMath : ConversionNumber() {

    fun sumNumbers(numberOne:String, numberTwo:String):Double {
        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    fun subtractNumbers(numberOne:String, numberTwo:String):Double {
        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    fun multiplyNumbers(numberOne:String, numberTwo:String):Double {
        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    fun divideNumbers(numberOne:String, numberTwo:String):Double {
        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    fun averageNumbers(numberOne:String, numberTwo:String):Double {
        return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2
    }

    fun squareRootNumbers(numberOne:String):Double {
        return sqrt(convertToDouble(numberOne))
    }
}