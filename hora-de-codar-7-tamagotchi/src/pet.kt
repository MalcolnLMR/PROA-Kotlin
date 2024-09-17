class pet(private val name : String) {
    // Max Status
    private val nourishmentMax = 100
    private val happinessMax = 100
    private val energyMax = 100

    // Decay Info
    private var nourishmentDecay: Int = -1 * (nourishmentMax / 10)
    private var happinessDecay: Int = -1 * (happinessMax / 10)
    private var energyDecay: Int = -1 * (energyMax / 20)

    // Actual values
    private var nourishmentActual: Int = nourishmentMax / 2
    private var happinessActual: Int = happinessMax / 2
    private var energyActual: Int = energyMax / 2

    // Other values
    private var age = 1
    var isAlive = true

    fun onEat(){
        addNourishment(50)
        addEnergy(5)
        act()
    }

    fun onPlay(){
        addHappiness(10)
        addNourishment(-5)
        addEnergy(-5)
        act()
    }

    fun onRest(){
        addEnergy(10)
        addNourishment(-5)
        act()
    }

    private fun addNourishment(value: Int){
        if (nourishmentActual + value > nourishmentMax) {
            nourishmentActual = nourishmentMax
            return
        }

        if (nourishmentActual + value <= 0){
            gameOver(GameOver.NOURISHMENT_ZERO)
            return
        }

        nourishmentActual += value
    }

    private fun addHappiness(value: Int){
        if (happinessActual + value > happinessMax) {
            happinessActual = happinessMax
            return
        }

        if (happinessActual + value <= 0){
            gameOver(GameOver.HAPPINESS_ZERO)
            return
        }

        happinessActual += value
    }

    private fun addEnergy(value: Int){
        if (energyActual + value > energyMax) {
            energyActual = energyMax
            return
        }

        if (energyActual + value <= 0){
            gameOver(GameOver.ENERGY_ZERO)
            return
        }

        energyActual += value
    }

    private fun gameOver(cause: GameOver){
        when(cause){
            GameOver.NOURISHMENT_ZERO -> {println("Morreu de fome :c"); isAlive = false}
            GameOver.HAPPINESS_ZERO -> {println("Morreu de tristeza :c"); isAlive = false}
            GameOver.ENERGY_ZERO -> {println("Morreu de cansaço :c"); isAlive = false}
        }
    }

    fun printInfo(){
        println("Status atual de $name:")
        println("Nutrição: $nourishmentActual")
        println("felicidade: $happinessActual")
        println("Energia: $energyActual")
        println("Idade: $age")
    }

    fun getName(): String {
        return name
    }

    fun getAge(): Int {
        return age
    }

    /* Exemplo de resultado esperado
     * Fome: |█████████████████████████████████████████████-----| 75/100
     *
     * para encontrar o número de barras foi feita uma regra de 3 simples
     * onde valueMax está para 50 assim como value está para X
     * 50 é o número de caracteres totais, e X é o número de barras atuais
     * rearranjando a conta, encontramos "(50*value)/valueMax = X"
     * e para descobrir a quantidade de traços, simplesmente reduzimos
     * a quantidade atual da quantidade máxima: "50-X".
     */

    fun printBar(barName: String, value: Int, valueMax: Int){
        print("$barName:${" ".repeat(15 - barName.length)}|")

        val numOfBars = (50*value)/valueMax
        print("${"█".repeat(numOfBars)}${"-".repeat(50-numOfBars)}| $value/$valueMax\n")
    }

    private fun act(){
        if (!isAlive) return

        addHappiness(happinessDecay)
        age++

        printBar("Alimentação", nourishmentActual, nourishmentMax)
        printBar("Felicidade", happinessActual, nourishmentMax)
        printBar("Energia", energyActual, nourishmentMax)
    }
}