import utils.Numbers
import utils.Rooms

class Hotel(main: MainApplication) {
    // Declarations
    private var rooms: Rooms = Rooms()
    private var mainApplication: MainApplication = main

    init {
        main.onStart += ::onStart
        main.onStop += ::onStop
    }

    fun start(){
        // Declarations
        var price: Double
        var days: Int
        var room: Int
        var guest: String
        var read: String

        /* TODO
         * Este trecho eu acabei fazendo com While(true)
         * não é a coisa mais segura e correta de ser feita
         * mas é o que tem para hoje, eventualmente eu revisito
         * isso aqui e arrumo :)
         */

        while (true){
            read = TextManager.askToUser("Qual o valor da diária?")
            if (Numbers.isNatural(read)) break
            println("Valor inválido, ${mainApplication.getUserName()}")
        }
        price = read.toDouble()

        while (true){
            read = TextManager.askToUser("Quantas diárias são necessárias?")
            if (Numbers.isNumeric(read) && read.toInt() in 1..30) break
            println("Valor inválido, ${mainApplication.getUserName()}")
        }
        days = read.toInt()

        println("O valor de $days dia${if (days > 0) "s" else ""} de hospedagem é de R$ ${price * days}")

        while (true){
            read = TextManager.askToUser("Qual o nome do hóspede?")
            //if (TextManager.askToConfirmation("Confirma o nome $read?")) break
            break
        }
        guest = read

        while (true){
            read = TextManager.askToUser("Qual quarto para reserva? (1-20)")
            if (Numbers.isNumeric(read) && read.toInt() in 1..20 && rooms.isRoomAvailable(read.toInt())) break
            println("Quarto está ocupado. Escolha outro.")
            println(rooms.getRoomAvailabilityText())

        }
        room = read.toInt()

        /* NOTA
         * Talvez escolher o ponto de retorno para esta função seja interessante
         */
        var read_bool: Boolean = TextManager.askToConfirmation("${mainApplication.getUserName()}, " +
                "você confirma a hospedagem para $guest por $days dia${if (days > 0) "s" else ""} para o " +
                "quarto $room por R$ ${price * days}?")
        if (read_bool) {
            if(!rooms.addClient(room, price, days)) {
                println("Erro ao adicionar")
            } else {
                println("${mainApplication.getUserName()}, reserva efetuada para $guest")
                println(rooms.getRoomAvailabilityText())
            }
        }
        println("\n• Retornando ao menu •\n")
    }

    fun onStart(){

    }

    fun onStop(){

    }


}