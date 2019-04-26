package number.utils

import calc.utils.CalcMath

class Number: CalcMath() {
    var numberOne:String = ""
    var numberTwo:String = ""

    fun setOnlyNumberOne(number:String) {
        this.numberOne = number
    }

    fun setNumbers(numberOne:String, numberTwo:String) {
        this.numberOne = numberOne
        this.numberTwo = numberTwo
    }

}