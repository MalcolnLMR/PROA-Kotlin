import org.w3c.dom.Text
import utils.Numbers
import utils.TextManager
import kotlin.math.ceil

class Events(main: MainApplication) {
    private val mainApplication = main

    // Rooms Info
    private val laranjaRoomMax = 150
    private val laranjaRoomAdditional = 70
    private val coloradoRoomMax = 350
    private val coloradoRoomAdditional = 0

    // Time Schedule
    private val weekDaysTimeRange = 7..23
    private val weekEndDaysTimeRange = 7..15

    // Buffet Info
    private val waiterHourCost = 10.5
    private val costumersForWaiter = 12
    private val hoursForWaiter = 2
    private val coffeeForEachCustomer = 0.2
    private val waterForEachCustomer = 0.5
    private val foodForEachCustomer = 7.0
    private val coffeeCost = 0.8
    private val waterCost = 0.4
    private val foodCost = 34


    // Event Configuration
    private var invitations: Int = 0
    private var isEventWeekDay: Boolean = false
    private var eventLocation: String = ""
    private var eventDay: String = ""
    private var eventName: String = ""
    private var eventTime: Int = 0
    private var eventDuration: Int = 0
    private var waitersCost: Double = 0.0
    private var waitersQuantity: Int = 0
    private var buffetCost: Double = 0.0

    init {
        main.onStart += ::onStart
        main.onStop += ::onStop
    }

    fun start(){
        setInvitationNumber()
        println("Agora vamos ver a agenda do evento")
        setDate()
        println("Auditório $eventLocation reservado para $eventName. $eventDay às $eventTime")
        setCrew()
        println("Agora vamos calcular o custo do buffet do hotel para o evento")
        setBuffet()


        // TODO Pergunta dessas merdas aqui AHAHAHAHAHAHAHHA OS NUMERO NÃO BATEM AAHAHAHHAHAHAHHAHAH
        // Finalization
        println("""
             Evento no Auditório $eventLocation.
             Nome da empresa: $eventName.
             Data: $eventDay, ${eventTime}H às ${eventTime + eventDuration}H.
             Duração do evento: ${eventDuration}H.
             Quantidade de garçons: $waitersQuantity.
             Quantidade de convidados: $invitations 
             
             Custo dos garçons: R$ $waitersCost
             Custo do Buffet: R$ $buffetCost
             
             Valor total do evento: R$ ${waitersCost + buffetCost}
        """.trimIndent())

        val read = TextManager.askToConfirmation("Gostaria de efetuar a reserva?")
        if (read) println("${mainApplication.getUserName()}, reserva efetuada com sucesso")
        else println("Reserva não efetuada")
    }

    private fun setInvitationNumber(){
        var read: String
        while (true) {
            read = TextManager.askToUser("Qual o número de convidados para o seu evento?")

            if (!(Numbers.isInt(read) || read.toInt() <= 0)) {
                println("Número de convidados inválido.")
                continue
            }

            if (read.toInt() < (laranjaRoomMax + laranjaRoomAdditional)){
                println("Use o auditório laranja " +
                        if (read.toInt() < laranjaRoomMax) "" else "(inclua mais ${read.toInt() - laranjaRoomMax} " +
                                "cadeiras)")
                invitations = read.toInt()
                eventLocation = "laranja"
                return
            } else if (read.toInt() > (coloradoRoomMax + coloradoRoomAdditional)){
                println("Quantidade de convidados superior à capacidade máxima.")
                continue
            } else {
                println("Use o auditório colorado " +
                        if (read.toInt() < coloradoRoomMax) "" else "(inclua mais ${read.toInt() - coloradoRoomMax}" +
                                " cadeiras)")
                invitations = read.toInt()
                eventLocation = "colorado"
                return
            }
        }
    }

    private fun setDate(){
        var read: String
        val auxDay: String
        val auxTime: Int

        while (true){
            read = TextManager.askToUser("Qual o dia do evento?")
            if (TextManager.isWeekDayValid(read)){ auxDay = read; break }
            println("Dia inválido")
        }


        while (true){
            read = TextManager.askToUser("Qual a hora do evento?")
            if(!Numbers.isInt(read)){ println("Resposta inválida."); continue }
            if(!isAvailable(auxDay, read.toInt())) { println("Horário inválido"); continue }
            auxTime = read.toInt()
            break
        }

        read = TextManager.askToUser("Qual o nome da empresa?")

        isEventWeekDay = !TextManager.isWeekDay(eventDay)
        eventName = read
        eventDay = auxDay
        eventTime = auxTime
    }

    private fun setCrew(){
        var read: String
        while (true){
            read = TextManager.askToUser("Qual a duração do evento em horas?")
            if (!Numbers.isInt(read)) { println("Resposta Inválida"); continue }
            if (isEventWeekDay && read.toInt() + eventTime > weekDaysTimeRange.last){
                println("O evento deve acabar antes das 23h00.")
                continue
            }else if (!isEventWeekDay && read.toInt() + eventTime > weekEndDaysTimeRange.last){
                println("O evento deve acabar antes das 15h00.")
                continue
            }
            eventDuration = read.toInt()
            break
        }

        var waitersNeeded: Double = (invitations.toDouble()/costumersForWaiter)
        waitersNeeded = ceil(waitersNeeded)
        waitersNeeded += eventDuration/hoursForWaiter
        waitersNeeded = ceil(waitersNeeded)

        waitersCost = waitersNeeded * waiterHourCost
        waitersQuantity = waitersNeeded.toInt()

        println("São necessários $waitersNeeded garçons")
        println("Custo: R$ $waitersCost")
    }

    private fun setBuffet(){
        val coffeeNeeded = ceil(invitations * coffeeForEachCustomer)
        val waterNeeded = ceil(invitations * waterForEachCustomer)
        val foodNeeded = ceil( ((invitations * foodForEachCustomer)/100) ) * 100

        println("O evento precisará de $coffeeNeeded litros de café, $waterNeeded litros de água e $foodNeeded salgados.")
        buffetCost = (coffeeNeeded * coffeeCost) + (waterNeeded * waterCost) + ( (foodNeeded/100) * foodCost)
    }


    private fun isAvailable(day: String, time: Int): Boolean{
        return if (TextManager.isWeekDay(day)){
            time in weekDaysTimeRange
        } else if (TextManager.isWeekEndDay(day)) {
            time in weekEndDaysTimeRange
        } else false
    }

    private fun onStart(){

    }

    private fun onStop(){
        //Talvez salvar algo em um arquivo aqui, sei lá
    }

}