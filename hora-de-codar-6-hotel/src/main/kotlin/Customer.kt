class Customer(main: MainApplication) {
    companion object{
        fun getDailyPriceModifierByAge(age: Int): Double{
            if (age in 7..59) return 1.0
            if (age in 0..6) return 0.0
            if (age in 60..150) return 0.5
            return -1.0 // On Error return -1
        }

        fun isAgeValid(age: Int): Double{
            if (age in 7..59) return 1.0
            if (age in 0..6) return 0.0
            if (age in 60..150) return 0.5
            return -1.0 // On Error return -1
        }
    }
}