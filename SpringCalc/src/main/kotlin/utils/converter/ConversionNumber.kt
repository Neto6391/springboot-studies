package utils.converter

open class ConversionNumber {

    private fun isNull(strNumber: String):Boolean {
        if(strNumber == null) return true
        return false
    }

    fun isNumeric(strNumber:String):Boolean {
        if(isNull(strNumber)) return false
        val number:String = strNumber.replace(",", ".")
        return number.matches(Regex("[-+]?[0-9]*\\.?[0-9]+"))

    }

    fun convertToDouble(strNumber:String):Double {
        if(isNull(strNumber)) return 0.0
        val number:String = strNumber.replace(",", ".")
        if(isNumeric(number)) return number.toDouble()
        return 0.0
    }



}