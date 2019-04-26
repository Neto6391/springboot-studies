package services.application

import org.springframework.stereotype.Service
import utils.converter.ConversionNumber
import kotlin.math.sqrt

@Service
class CalcMathServices : ConversionNumber() {

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

    fun squareRootNumbers(number:String):Double {
        return sqrt(convertToDouble(number))
    }
}