package utils

class TextManager {
    companion object{
        var hotelName = "Terabitia"

        private var menu: String = """Selecione uma opção
        1) Reserva de Quartos
        2) Cadastro de Hóspedes
        3) Abastecimento de Carros
        4) Sair
    """.trimMargin()

        private var customerMenu: String = """Selecione uma opção
        1) Cadastrar
        2) Pesquisar
        3) Listar
        4) Sair
    """.trimMargin()

        private var trueOptions = listOf("sim", "s", "y", "yes")
        private var falseOptions = listOf("não", "nao", "n", "not")


        fun getMenu(): String{
            return menu
        }

        fun getCustomerMenu(): String{
            return customerMenu
        }

        fun askToUser(question: String): String{
            var response: String = ""
            while (true){
                print("$question\nResposta: ")
                response = readln()
                if (response.isNotBlank()) break
                println("\n• Resposta inválida •\n")
            }
            return response
        }

        fun askToConfirmation(question: String): Boolean{
            var response: String
            while (true){
                println("$question\nResposta (S/N): ")
                response = readln()
                if (isTrue(response) || isFalse(response)) break
                println("\n• Resposta inválida •\n")
            }
            return (isTrue(response))
        }

        fun isTrue(text: String): Boolean{
            return (text.lowercase() in trueOptions)
        }
        fun isFalse(text: String): Boolean{
            return (text.lowercase() in falseOptions)
        }

    }


    constructor(){

    }
}