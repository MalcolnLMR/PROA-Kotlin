fun main() {
    println("Bem-vindo ao Simulador de Animal de Estimação Virtual!")
    println("Digite o nome do seu animal de estimação:")
    val _nomePet = readln()
    val nomePet = if (_nomePet == "") "Gabriel" else _nomePet
    val pet = pet(nomePet)

    while (true) {
        println("\nEscolha uma ação:")
        println("1. Alimentar $nomePet")
        println("2. Brincar com $nomePet")
        println("3. Descansar com $nomePet")
        println("4. Tomar banho com $nomePet")
        println("5. Ir ao banheiro com $nomePet")
        println("6. Verificar o status de $nomePet")
        println("7. Sair")

        val escolha = readlnOrNull()?.toIntOrNull() ?: continue

        when (escolha) {
            1 -> pet.onEat()
            2 -> pet.onPlay()
            3 -> pet.onRest()
            4 -> pet.onShower()
            5 -> pet.onToilet()
            6 -> pet.onCheck()
            7 -> {
                println("Saindo do Simulador de Animal de Estimação Virtual. Adeus!")
                return
            }
            else -> {println("Escolha inválida. Tente novamente."); return}
        }
        if (!pet.isAlive) {break}

        // Simula o tempo que passa após cada ação
    }
    println("Você chegou ao turno ${pet.getAge()}!")
}