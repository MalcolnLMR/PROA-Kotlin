import kotlin.random.Random

// Global Variables
var isAppRunning : Boolean = true
var userName : String = ""

var bankStatement : Array<String> = arrayOf()
var bankBalance : Double = 0.0
var bankPassword : String = "0000"

// Main Function
fun main() {
    startApplication()
}

fun startApplication(){
    userName = askToUser("Qual o seu nome?")
    broadcast("Olá $userName é um prazer ter você por aqui!")

    loadAccountInfo()

    // Main loop
    var option : Int
    while (isAppRunning){
        option = askToUserNumber(getMenu()).toInt()
        when (option){
            1 -> menuSaldo()
            2 -> menuExtrato()
            3 -> menuSaque()
            4 -> menuDeposito()
            5 -> menuTransferencia()
            6 -> menuSair()
        }
    }

    broadcast("$userName, foi um prazer ter você por aqui!")
}

// List of Menus
fun menuSaldo(){
    if(!requestPassword()) return

    broadcast("Seu saldo é R$ $bankBalance".replace(".", ","))
    waitForUser()
}

fun menuExtrato(){
    if(!requestPassword()) return

    broadcast("Suas compras foram: ${bankStatement.toList()}"
        .replace("[", "\n")
        .replace(", ", "\n")
        .replace("]", ""))
    waitForUser()
}

fun menuSaque(){
    if(!requestPassword()) return
    val value : Double = requestValueToWithdraw()
    if(value == -1.0) return

    bankBalance -= value
    bankStatement += "Saque: R$ $value".replace(".",",")

    broadcast("Seu saldo agora é de R$ $bankBalance".replace(".", ","))
    waitForUser()
}

fun menuDeposito(){
    val value : Double = askToUserNumber("Quanto irá Depositar?")
    if (value <= 0.0) {broadcast("Operação não autorizada."); waitForUser(); return}

    bankBalance += value
    bankStatement += "Depósito: R$ $value".replace(".",",")

    broadcast("Seu saldo agora é de R$ $bankBalance".replace(".", ","))
    waitForUser()
}

fun menuTransferencia(){
    if(!requestPassword()) return
    val account : Double = askToUserNumber("Transferência para qual conta?")
    val value : Double = requestValueToWithdraw()
    if (value <= 0.0) {broadcast("Operação não autorizada."); waitForUser(); return}

    bankBalance -= value
    val accountString : String = account.toString().replace(".0", "")
    bankStatement += "Transferência para $accountString: R$ $value".replace(".",",")

    broadcast("Seu saldo agora é de R$ $bankBalance".replace(".", ","))
    waitForUser()
}

fun menuSair(){
    isAppRunning = false
}


// Helpful functions
fun askToUser(question: String): String {
    var loop = true
    var read = ""
    while (loop){
        print("$question\nResposta: ")
        read = readln()
        if (read == "") broadcast("Resposta Inválida.")
        else loop = false
    }
    return read
}

fun askToUserNumber(question: String): Double {
    var loop = true
    var read = "0"
    while (loop){
        print("$question\nResposta: ")
        read = readln()
        if (isNumeric(read)) loop = false
        else broadcast("Resposta Inválida.")
    }
    return read.toDouble()
}

fun waitForUser(){
    broadcast("Aperte ENTER para continuar...")
    readln()
}

fun requestPassword():Boolean{
    var password : String
    password = askToUser("Qual a senha?")
    while (password != bankPassword){
        broadcast("Senha Inválida, digite 0000 para sair")
        password = askToUser("Qual a senha?")
        if (password == "0000") return false
    }
    return true
}

fun requestValueToWithdraw():Double{
    val value : Double = askToUser("Qual o valor?").toDouble()
    if (value <= 0 || value > bankBalance){
        broadcast("Operação Inválida.")
        waitForUser()
        return -1.0
    }
    return value
}

fun loadAccountInfo(){
    bankBalance = 5000.00
    bankPassword = "3589"

    val purchases : Array<String> = arrayOf("Mercado", "Steam", "Bar", "Shopping", "Transferência para #ACC", "Saque")
    for (i in 1..Random.nextInt(5, 16)){
        var statement = ""
        statement += purchases[Random.nextInt(0, 6)].replace("#ACC", ""+Random.nextInt(1, 5000))
        statement += ": "
        statement += "R$ " + Random.nextInt(1, 500) + ",00"
        bankStatement += statement
    }
}

fun isNumeric(stringToCheck: String): Boolean {
    return stringToCheck.toDoubleOrNull() != null
}

fun getMenu(): String{
    val menu : String = """ 
        Menu Principal:
        1. Saldo
        2. Extrato
        3. Saque
        4. Depósito
        5. Transferência
        6. Sair
    """.trimIndent()
    return menu
}

fun broadcast(message: String){
    println("\n" + message)
}