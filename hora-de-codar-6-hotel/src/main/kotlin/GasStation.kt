import utils.Numbers
import utils.TextManager
import kotlin.math.floor

class GasStation(main: MainApplication) {
    private val mainApplication = main

    private val gasStations = mutableListOf("Wayne Oil", "Stark Petrol")

    fun start(){
        val prices = mutableListOf<Double>()

        var read: String
        for(i in 0..<gasStations.size*2){
           while(true){
               read = TextManager.askToUser("Qual o valor d${if (i%2==0) "o álcool" else "a gasolina"} " +
                       "no posto ${gasStations[floor((i/2.0)).toInt()]}")
               if (!Numbers.isNumeric(read)) { println("Respostá inválida.") ;continue }
               prices.add(read.toDouble())
               break
           }
        }

        var bestAlcoholValueIndex = 0
        var bestGasValueIndex = 1
        for((i, value) in prices.withIndex()){
            if (i % 2 == 0){
                if (prices[bestAlcoholValueIndex] > value){
                    bestAlcoholValueIndex = i
                }
            } else {
                if (prices[bestGasValueIndex] > value){
                    bestGasValueIndex = i
                }
            }
        }
        if (prices[bestAlcoholValueIndex] <= prices[bestGasValueIndex] * 0.7){
            println("${mainApplication.getUserName()}, é mais barato abastecer com álcool no posto" +
                    " ${gasStations[floor((bestGasValueIndex/2.0)).toInt()]}")
        } else {
            println("${mainApplication.getUserName()}, é mais barato abastecer com gasolina no posto" +
                    " ${gasStations[floor((bestAlcoholValueIndex/2.0)).toInt()]}")
        }
    }
}