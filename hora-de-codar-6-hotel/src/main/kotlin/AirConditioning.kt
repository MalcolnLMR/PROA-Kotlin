import utils.Numbers
import utils.TextManager

class AirConditioning(main: MainApplication) {
    private val mainApplication = main

    private val airConditioningNames = mutableListOf<String>()
    private val airConditioningPrices = mutableListOf<Double>()

    fun start(){
        while (true){
            getNewAirConditioningName()
            if(!TextManager.askToConfirmation("Deseja informar novos dados, ${mainApplication.getUserName()}?")){
                break
            }
        }
        printBestPrice()
    }

    private fun getNewAirConditioningName(){
        val auxPrice: Double
        var read: String

        val auxName: String = TextManager.askToUser("Qual o nome da empresa?")

        val auxPricePerUnit: Double
        while(true){
            read = TextManager.askToUser("Qual o nome da empresa?")
            if (Numbers.isNumeric(read)) { auxPricePerUnit = read.toDouble(); break }
            println("Resposta Inválida.")
        }

        val auxQuantity: Int
        while(true){
            read = TextManager.askToUser("Qual a quantidade de aparelhos?")
            if (Numbers.isInt(read)) { auxQuantity = read.toInt(); break }
            println("Resposta Inválida.")
        }

        val auxDiscountPercentage: Double
        while(true){
            read = TextManager.askToUser("Qual a porcentagem de desconto?")
            if (Numbers.isNumeric(read)) { auxDiscountPercentage = read.toDouble(); break }
            println("Resposta Inválida.")
        }

        val auxMinimumAmountToDiscount: Int
        while(true){
            read = TextManager.askToUser("Qual o número de aparelhos mínimos para conseguir desconto?")
            if (Numbers.isInt(read) && read.toInt() >= 0) { auxMinimumAmountToDiscount = read.toInt(); break }
            println("Resposta Inválida.")
        }

        val auxModifier = if (auxQuantity >= auxMinimumAmountToDiscount) (1 - (auxDiscountPercentage/100.0)) else 1.0
        auxPrice = (auxPricePerUnit * auxQuantity) * auxModifier

        println("O Serviço de $auxName custará R$ $auxPrice")
        airConditioningNames.add(auxName)
        airConditioningPrices.add(auxPrice)
    }

    private fun printBestPrice(){
        var bestPriceIndex = 0
        for((i, value) in airConditioningPrices.withIndex()){
            if (airConditioningPrices[bestPriceIndex] > value){
                bestPriceIndex = i
            }
        }
        println("O orçamento de menor valor é o [${airConditioningNames[bestPriceIndex]} por R$ " +
                "${airConditioningPrices[bestPriceIndex]}]")
    }
}