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
        val price: Double
        val priceCalculated: Double
        val days: Int
        val room: Int

        var guestFreeDailyCounter = 0
        var guestHalfDailyCounter = 0
        var guestFullDailyCounter = 0

        var read: String

        /* NOTA 27/08/2024 19:10
         * Este trecho eu acabei fazendo com While(true)
         * não é a coisa mais segura e correta de ser feita,
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

        /* NOTA 27/08/2024 19:10
         * Achei esquisito que ao perguntar os hóspedes, nós solicitamos o nome
         * e não usamos esta informação para nada, mas como está desta forma no enunciado
         * não irei alterar por hora
         */

        var auxGuest: String
        var auxModifier: Double
        while (true){
            read = TextManager.askToUser("Qual o nome do hóspede?")
            if (read.lowercase() == "pare") break
            auxGuest = read

            while (true){
                read = TextManager.askToUser("Qual a idade do hóspede?")
                if (Numbers.isNumeric(read) && read.toInt() in 0..150) break
                println("Número inválido, ${mainApplication.getUserName()}")
            }

            auxModifier = Customer.getDailyPriceModifierByAge(read.toInt())
            when (auxModifier){
                0.0 -> guestFreeDailyCounter++
                0.5 -> guestHalfDailyCounter++
                1.0 -> guestFullDailyCounter++
                else -> {println("Erro ao cadastrar $auxGuest"); continue}
            }

            /* NOTA
             * Este trecho ficou um pouco complexo, vou explicar como ele funciona:
             * o println() está pegando o nome do hóspede, e irá dividir usando os " " (espaços)
             * e ao fazer isso, pega o primeiro valor, traduzindo, ele verifica onde está a diferença
             * de nome e sobrenome, separa a 'string' numa lista e pega o primeiro valor.
             * Após isso, ele verifica qual o modificador de preço usado, e dependendo do valor
             * escreve "possui gratuidade" ou "paga meia"
             */
            println("$auxGuest cadastrada(o) com sucesso. ${if (auxModifier != 1.0) auxGuest.split(" ")[0] +
                    (if (auxModifier == 0.0) " possui gratuidade" else " paga meia")
                    else ""}")
        }
        priceCalculated = (price * guestFullDailyCounter  * days) + (price * guestHalfDailyCounter * 0.5  * days)
        println("${mainApplication.getUserName()}, o valor total das hospedagens é: R$ ${priceCalculated}; " +
                "${if (guestFreeDailyCounter > 0) "$guestFreeDailyCounter gratuidade(s)" else ""}; " +
                "${if (guestHalfDailyCounter > 0) "$guestHalfDailyCounter meia(s)" else ""}; ")

        while (true){
            read = TextManager.askToUser("Qual quarto para reserva? (1-20)")
            if (Numbers.isNumeric(read) && read.toInt() in 1..20 && rooms.isRoomAvailable(read.toInt())) break
            println("Quarto está ocupado. Escolha outro.")
            println(rooms.getRoomAvailabilityText())

        }
        room = read.toInt()

        /* NOTA 27/08/2024 19:10
         * Talvez escolher o ponto de retorno para esta função seja interessante
         */
        val readBool: Boolean = TextManager.askToConfirmation("${mainApplication.getUserName()}, " +
                "você confirma a hospedagem por $days dia${if (days > 0) "s" else ""} para o " +
                "quarto $room por R$ ${priceCalculated}?")
        if (readBool) {
            if(!rooms.addClient(room, price, days)) {
                println("Erro ao adicionar")
            } else {
                println("${mainApplication.getUserName()}, reserva efetuada")
                println(rooms.getRoomAvailabilityText())
            }
        }
        println("\n• Retornando ao menu •\n")
    }

    private fun onStart(){

    }

    private fun onStop(){

    }


}