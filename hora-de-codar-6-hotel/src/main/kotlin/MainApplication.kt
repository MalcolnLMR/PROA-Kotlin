import utils.Event
import utils.Numbers
import utils.TextManager

class MainApplication {
    // Values
    private val userPassword: String = "2678"

    // Variables
    private lateinit var userName: String
    private var isAppRunning: Boolean = false

    // Other classes
    private lateinit var hotel: Hotel
    private lateinit var customer: Customer
    private lateinit var event: Events
    private lateinit var gasStation: GasStation
    private lateinit var airConditioning: AirConditioning

    // Events
    var onStart: Event = Event()
    var onStop: Event = Event()


    fun startApplication(){
        isAppRunning = true // Start application

        // Starting other classes
        hotel = Hotel(this)
        customer = Customer(this)
        event = Events(this)
        gasStation = GasStation(this)
        airConditioning = AirConditioning(this)

        login()

        onStart()
        println("Bem vindo ao Hotel ${TextManager.hotelName}, $userName. É um imenso prazer ter você por aqui!")
        // Main Loop
        var read: String
        while (isAppRunning){
            read = TextManager.askToUser(TextManager.getMenu())

            if (!(Numbers.isInt(read) && read.toInt() in 1..6)){
                println("Por favor, informe um número entre 1 e 6.")
                continue
            }

            when (read.toInt()) {
                1 -> hotel.start()
                2 -> customer.start()
                3 -> gasStation.start()
                4 -> event.start()
                5 -> airConditioning.start()
                6 -> sair()
                else -> continue
            }
        }
        println("Muito obrigado e até logo, $userName")

        onStop()
    }

    private fun login(){
        userName = TextManager.askToUser("Qual o seu nome?")


        var password = TextManager.askToUser("Qual a senha?")
        while (password != userPassword){
            println("\nSenha incorreta.")
            password = TextManager.askToUser("Qual a senha?")
        }

    }

    fun getUserName(): String{
        return userName
    }

    private fun sair(){
        println("Você deseja sair? s/n")

        val option: String = readln()
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