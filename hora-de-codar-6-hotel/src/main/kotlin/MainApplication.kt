import java.lang.runtime.TemplateRuntime
import utils.Event

class MainApplication() {
    // Values
    val userPassword: String = "2678"
    val hotelName: String = "Terabitia"


    // Variables
    lateinit var userName: String
    var isAppRunning: Boolean = false

    // Other classes
    lateinit var customer: Customer
    lateinit var hotel: Hotel

    var onStart = Event()


    fun startApplication(){
        isAppRunning = true // Start application

        // Starting other classes
        customer = Customer(this)
        hotel = Hotel(this)


        // Main Loop
        var option: Int
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

    fun login(){
        userName = askQuestion("Qual o seu nome?")


        var password = askQuestion("Qual a senha?")
        while (userName != "2678"){
            println("\nSenha incorreta.")
            password = askQuestion("Qual a senha?")
        }

        println("Bem vindo ao Hotel $hotelName, $userName. É um imenso prazer ter você por aqui!")
    }

    fun askQuestion(question: String) : String{
        print("$question\nResposta: ")
        return readln()
    }
}