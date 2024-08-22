// Global Variables
var isAppRunning: Boolean = true
var userPassword: String = ""
var userName: String = ""
var hotelName: String = "SuperManeiro"


fun main() {
    startApplication()
}

fun startApplication(){
    onStart()

    // Declarations
    var option: Int

    // Main Loop
    while (isAppRunning){
        option = askQuestion(getMenu()).toInt()
        when (option) {
            1 -> reserva_quarto()
            2 -> cadastro_hospede()
            3 -> abastecer_carros()
            4 -> sair()
            else -> erro()
        }
    }

    onStop()
}

// Funções minhas

fun login(){
    userName = askQuestion("Qual o seu nome?")

    userPassword = askQuestion("Qual a senha?")
    while (userName != "2678"){
        println("\nSenha incorreta.")
        userPassword = askQuestion("Qual a senha?")
    }

    println("Bem vindo ao Hotel $hotelName, $userName. É um imenso prazer ter você por aqui!")
}

fun onStart(){
    login()
}

fun onStop(){
    println("Muito obrigado e até logo, $userName")
}

fun getMenu() : String{
    return """Selecione uma opção
        1) Reserva de Quartos
        2) Cadastro de Hóspedes
        3) Abastecimento de Carros
        4) Sair
    """.trimMargin()
}

fun waitForUser(){
    println("Aperte ENTER para continuar...")
    readln()
}

fun askQuestion(question: String) : String{
    print(question + "\nResposta: ")
    return readln()
}

// Funções diretas do professor

fun reserva_quarto(){
    println("HOTEL $hotelName - RESERVA DE QUARTOS")
}

fun cadastro_hospede(){
    println("HOTEL $hotelName - CADASTRO DE HÓSPEDES")
    main_cadastrar()
}

fun abastecer_carros(){
    println("HOTEL $hotelName - ABASTECER")
}

fun erro(){
    println("Por favor, informe um número entre 1 e 4")
}

fun sair(){
    println("Você deseja sair? s/n")

    var option: String = readln()
    if(option.lowercase() == "s"){
        isAppRunning = false
    } else if(option.lowercase() == "n") {
      //todo
    } else {
        println("Desculpe, mas não compreendi")
        sair()
    }
}
