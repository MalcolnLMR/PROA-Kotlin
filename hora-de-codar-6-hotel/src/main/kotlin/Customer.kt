import utils.Numbers
import utils.TextManager

class Customer(main: MainApplication) {
    companion object{
        fun getDailyPriceModifierByAge(age: Int): Double{
            if (age in 7..59) return 1.0
            if (age in 0..6) return 0.0
            if (age in 60..150) return 0.5
            return -1.0 // On Error return -1
        }
    }

    private val maxCustomers = 15
    private var actualCustomers: Int = 0
    private lateinit var customers : MutableList<String>

    init {
        main.onStart += ::onStart
        main.onStop += ::onStop
    }

    fun start(){

        // Main Loop
        var read: String
        while (true){
            read = TextManager.askToUser(TextManager.getCustomerMenu())

            if (!(Numbers.isInt(read) && read.toInt() in 1..4)){
                println("Por favor, informe um número entre 1 e 4.")
                continue
            }

            when (read.toInt()) {
                1 -> registerCustomer()
                2 -> searchCustomer()
                3 -> listCustomer()
                4 -> break
            }
        }
    }

    private fun registerCustomer(){
        if (actualCustomers >= maxCustomers) {
            println("Máximo de usuários cadastrados atingidos")
            return
        }

        val read = TextManager.askToUser("Qual o nome do Hóspede?")
        customers.add(read)
        actualCustomers++

        println("Hóspede $read foi cadastrado(a) com sucesso!")
    }

    private fun searchCustomer(){
        val read = TextManager.askToUser("Qual o nome do Hóspede?")
        if (customers.any { it.contains(read, ignoreCase = true) }) {
            println("\nEncontramos a(s) hóspede(s):")
            // TODO
            // Atividade pede "exatamente igual", está é uma solução temporária
            customers.filter { it.contains(read, ignoreCase = true) }
                .forEach { println("• $it") }
            return
        }
        println("Hóspede $read não foi encontrado")
    }

    private fun listCustomer(){
        println("\nEste(s) são o(s) hóspede(s):")
        for (customer in customers){
            println(" • $customer")
        }
    }

    private fun onStart(){
        customers = mutableListOf()
        customers.add("Carlos Villagran")
        customers.add("Maria Antonieta de las Nieves")
        customers.add("Roberto Gómez Bolaños")
        customers.add("Florinda Meza")
        customers.add("Ramón Valdés")
        customers.add("Rubén Aguirre")
        customers.add("Angelines Fernández")
        customers.add("Edgar Vivar")
        customers.add("Horácio Gómez Bolaños")
        customers.add("Raúl Padilla")
        actualCustomers = 10
    }

    private fun onStop(){
        //Talvez salvar algo em um arquivo aqui, sei lá
    }

}