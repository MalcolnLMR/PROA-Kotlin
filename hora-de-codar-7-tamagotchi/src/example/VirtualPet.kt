class VirtualPet(private val nome: String) {
    private var nivelDeFome = 50
    private var nivelFelicidade = 50

    fun alimentar() {
        nivelDeFome -= 10
        println("$nome foi alimentado. O nível de fome diminuiu.")
    }

    fun brincar() {
        nivelFelicidade += 10
        println("$nome está brincando e se sentindo mais feliz.")
    }

    fun verificarStatus() {
        println("Status atual de $nome:")
        println("Nível de fome: $nivelDeFome")
        println("Nível de felicidade: $nivelFelicidade")
    }

    fun passarTempo() {
        nivelDeFome += 5
        println("$nome está ficando mais faminto com o passar do tempo.")
    }

    fun status() {
        println("Status não implementado")
    }
}
