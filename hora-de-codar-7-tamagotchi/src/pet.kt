class pet(private val name : String) {
    // Max Status
    private val nourishmentMax = 100
    private val happinessMax = 100
    private val energyMax = 100
    private val toiletEmptynessMax = 100
    private val cleanMax = 100


    // Decay Info
    private var nourishmentDecay: Int = -1 * (nourishmentMax / 10)
    private var happinessDecay: Int = 30
    private var energyDecay: Int = 10
    private var toiletEmptynessDecay: Int = 10
    private var cleanDecay: Int = 10

    // Actual values
    private var nourishmentActual: Int = nourishmentMax / 2
    private var happinessActual: Int = happinessMax / 2
    private var energyActual: Int = energyMax / 2
    private var toiletEmptynessActual: Int = toiletEmptynessMax / 2
    private var cleanActual: Int = cleanMax / 2

    // Other values
    private var age = 1
    var isAlive = true

    fun onEat(): Boolean{
        addNourishment(50)
        addEnergy(5)
        addToiletEmptyness(10)
        act()
        return true
    }

    fun onPlay(): Boolean{
        addHappiness(10)
        addNourishment(-5)
        addEnergy(-5)
        act()
        return true
    }

    fun onRest(): Boolean{

        if (energyActual >= 100) {
            println("${getName()} não precisa dormir!")
            return false
        }

        var choice = 0
        while (choice !in 1..8){
            println("Quanto tempo ${getName()} deve dormir?")
            choice = readlnOrNull()?.toIntOrNull() ?: continue
        }

        val value = when(choice){
            1 -> 10
            2 -> 20
            3 -> 30
            4 -> 40
            5 -> 50
            6 -> 60
            7 -> 80
            8 -> 100
            else -> 0
        }

        addEnergy(value)
        addNourishment(-5)
        addToiletEmptyness(-value/2)
        act()
        return true
    }

    fun onCheck(): Boolean{
        printInfo()
        return true
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
    private fun addClean(value: Int){
        if (cleanActual + value > cleanMax) {
            cleanActual = cleanMax
            return
        }

        if (cleanActual + value <= 0){
            gameOver(GameOver.CLEAN_ZERO)
            return
        }

        cleanActual += value
    }

    private fun addToiletEmptyness(value: Int){
        if (toiletEmptynessActual + value > toiletEmptynessMax){
            toiletEmptynessActual = toiletEmptynessMax
            return
        }

        if (toiletEmptynessActual + value <= 0){
            gameOver(GameOver.TOILET_ZERO)
            return
        }

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
            GameOver.NOURISHMENT_ZERO -> {println("$name morreu de fome :c"); isAlive = false}
            GameOver.HAPPINESS_ZERO -> {println("$name morreu de tristeza :c"); isAlive = false}
            GameOver.ENERGY_ZERO -> {println("$name morreu de cansaço :c"); isAlive = false}
            GameOver.TOILET_ZERO -> {println("$name morreu de cocô :c"); isAlive = false}
            GameOver.CLEAN_ZERO -> {println("$name morreu de sujo :c"); isAlive = false}
        }
    }

    fun printInfo(){
        println("Status atual de ${getName()}")
        printBar("Alimentação", nourishmentActual, nourishmentMax)
        printBar("Felicidade", happinessActual, happinessMax)
        printBar("Energia", energyActual, energyMax)
        printBar("Vontades atendidas", toiletEmptynessActual, toiletEmptynessMax)
        printBar("Limpeza", cleanActual, cleanMax)

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
        print("$barName:${" ".repeat(20 - barName.length)}|")

        val numOfBars = (50*value)/valueMax
        print("${"█".repeat(numOfBars)}${"-".repeat(50-numOfBars)}| $value/$valueMax\n")
    }

    private fun act(){
        if (!isAlive) return

        addHappiness(happinessDecay)
        addEnergy(energyDecay)
        age++

        printInfo()
    }
}
/*⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣴⠶⠾⠟⠛⠛⠷⢶⣤⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⠾⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⡆
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡾⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿
⠀⠀⠀⠀⠀⠀⢀⣀⣤⡶⠾⠟⠛⠛⠛⠛⠻⠷⢶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣼⠏
⠀⠀⠀⠀⣠⡶⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣤⣶⠶⠟⠛⠁⠀
⠀⠀⣴⡟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⡟⠁⠀⠀⠀⠀⠀⠀⠀⣀⣤⣴⠶⠟⠛⠋⠉⠀⠀⠀⠀⠀⠀⠀
⢀⣾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠏⠀⠀⠀⠀⠀⣀⣤⡾⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⣼⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡾⠛⠻⢶⣤⣀⠀⠀⠀⠘⣧⠀⠀⠀⠀⠀⢀⣼⠏⠀⠀⣠⣴⠿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡾⠛⠁⠀⠀⠀⠀⠈⠛⢷⣄⠀⠀⢹⣧⣤⣶⣶⣶⣾⠏⠀⣤⡾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⢻⣆⡀⠀⠀⠀⢀⣀⣤⣴⠾⠛⠁⠀⠀⠀⠀⠀⠀⢀⣤⣶⠿⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠻⢶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠉⠛⠛⠛⠛⠛⠋⠉⠀⠀⠀⠀⠀⠀⠀⢀⣤⡾⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⢷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣟⣃⣤⣤⣤⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣴⣶⣶⣶⣶⣬⣻⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⡿⣻⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣎⠻⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢢⣿⠋⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⢠⣿⡿⢿⣿⣿⠿⣿⣿⣿⣿⣿⣇⠘⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠃⢸⣿⣿⣿⣿⣿⡁⠈⠻⠉⠀⣹⣿⡄⠀⠀⠀⠀⠀⣼⣿⡄⠀⠙⠁⠀⣼⣿⣿⣿⣿⣿⡀⢸⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡟⠀⢸⣿⣿⣿⣿⣿⣷⣄⡀⣀⣶⣿⣿⡇⠀⠀⠀⠀⠀⣿⣿⣿⣦⣀⣠⣾⣿⣿⣿⣿⣿⣿⠃⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣧⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⢠⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡄⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠁⠀⣼⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣤⠤⠬⠿⠿⠿⠿⠿⠿⠿⠿⠿⠇⠀⠀⢾⣿⡷⠀⠀⠨⠿⠟⠛⠛⠛⠋⠉⠉⠉⠑⢺⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠹⣧⡤⠶⠶⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠤⣍⣉⣹⡿⠑⠒⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⣈⢿⣾⡉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠒⠶⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠏⠒⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠊⠀⠀⠙⠻⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡾⠛⠁⠀⠀⠀⠈⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠻⢶⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣶⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⣿⠛⣿⠿⠷⠶⠶⠶⠿⠛⢻⡟⢻⣇⣀⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⡟⠛⠛⠛⠛⢸⡏⠀⠀⠀⠀⠀⣠⡶⠾⢷⣬⡛⠉⠉⠉⢻⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⡄⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⣾⠋⠀⠀⠀⠙⣿⠀⠀⢀⣼⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢶⣤⣤⡶⢿⡇⠀⠀⠀⢸⡏⠀⠀⠀⠀⠀⣿⡷⠾⠟⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⡇⠀⠀⠀⠈⣿⣄⠀⡄⠀⣠⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⣿⡟⠷⠷⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⡇⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣇⠀⢀⠀⢀⣾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⢶⣼⣴⠾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀*/
