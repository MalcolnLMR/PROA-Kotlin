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
            val num: Double
            try {
                num = number.toDouble()
            } catch (e: NumberFormatException){
                return false
            }
            return (num > 0.0)
        }

        fun isNumeric(number: String): Boolean{
            try {
                number.toDouble()
            } catch (e: NumberFormatException){
                return false
            }
            return true
        }

        fun isInt(number: String): Boolean{
            try {
                number.toInt()
            } catch (e: NumberFormatException){
                return false
            }
            return true
        }
    }
}