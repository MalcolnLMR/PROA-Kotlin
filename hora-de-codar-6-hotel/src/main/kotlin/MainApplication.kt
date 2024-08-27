import java.lang.runtime.TemplateRuntime
import utils.Event

class MainApplication {
    // Values
    val userPassword: String = "2678"

    // Variables
    private lateinit var userName: String
    private var isAppRunning: Boolean = false

    // Other classes
    lateinit var customer: Customer
    lateinit var hotel: Hotel

    // Events
    var onStart: Event = Event()
    var onStop: Event = Event()


    fun startApplication(){
        isAppRunning = true // Start application

        // Starting other classes
        customer = Customer(this)
        hotel = Hotel(this)

        login()
        onStart()

        println("Bem vindo ao Hotel ${TextManager.hotelName}, $userName. É um imenso prazer ter você por aqui!")
        // Main Loop
        var option: Int
        while (isAppRunning){
            option = askQuestion(TextManager.getMenu()).toInt()
            when (option) {
                1 -> hotel.start()
                2 -> true
                3 -> true
                4 -> sair()
                else -> true
            }
        }
        println("Muito obrigado e até logo, $userName")

        onStop()
    }

    fun login(){
        userName = askQuestion("Qual o seu nome?")


        var password = askQuestion("Qual a senha?")
        while (password != userPassword){
            println("\nSenha incorreta.")
            password = askQuestion("Qual a senha?")
        }

    }

    fun askQuestion(question: String) : String{
        print("$question\nResposta: ")
        return readln()
    }

    fun getUserName(): String{
        return userName
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
}