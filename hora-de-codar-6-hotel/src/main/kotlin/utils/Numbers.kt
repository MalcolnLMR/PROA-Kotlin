package utils

class Numbers {

    companion object{
        fun isNatural(number: Int): Boolean {
            return (number > 0)
        }

        fun isNatural(number: Double): Boolean {
            return (number > 0.0)
        }

        fun isNatural(number: String): Boolean {
            var _num: Double = -1.0
            try {
                _num = number.toDouble()
            } catch (e: NumberFormatException){
                return false
            }
            return (_num > 0.0)
        }

        fun isNumeric(number: String): Boolean{
            var _num: Double = -1.0
            try {
                _num = number.toDouble()
            } catch (e: NumberFormatException){
                return false
            }
            return true
        }

        fun isInt(number: String): Boolean{
            var _num: Int = -1
            try {
                _num = number.toInt()
            } catch (e: NumberFormatException){
                return false
            }
            return true
        }
    }
}