
fun main() {
    println("Bem-vindo ao Simulador de Animal de Estimação Virtual!")
    println("Digite o nome do seu animal de estimação:")
    val nomePet = readLine() ?: "Baltazar Guilherme Tenório"
    val pet = VirtualPet(nomePet)



    while (true) {
        println("\nEscolha uma ação:")
        println("1. Alimentar $nomePet")
        println("2. Brincar com $nomePet")
        println("3. Verificar o status de $nomePet")
        println("4. Sair")

        val escolha = readLine()?.toIntOrNull() ?: continue

       when (escolha) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> pet.status()
            4 -> {
                println("Saindo do Simulador de Animal de Estimação Virtual. Adeus!")
                return
            }
            else -> println("Escolha inválida. Tente novamente.")
        }

        pet.passarTempo() // Simula o tempo que passa após cada ação
    }
}