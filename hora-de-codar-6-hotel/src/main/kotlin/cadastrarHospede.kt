// Global Variables
var isCadastroHospedeRunning: Boolean = false
var listaHospedes: ArrayList<String> = arrayListOf()

fun main_cadastrar(){
    onStart_cadastro()

    var option: Int
    while (isCadastroHospedeRunning){
        option = askQuestion("""Cadastro de Hóspede
        Selecione uma opção
        1) Cadastrar
        2) Pesquisar
        3) Sair
    """.trimMargin()).toInt()

        when(option){
            1 -> cadastrar_hospedes()
            2 -> pesquisar_hospedes()
            3 -> sair_hospede()
            else -> erro_hospedes()
        }
    }

    onStop_cadastro()
}

fun onStart_cadastro(){
    isCadastroHospedeRunning = true
    listaHospedes.add("Fernando Netto")
    listaHospedes.add("Gabriel Augusto Azevedo")
    listaHospedes.add("Fernanda Monteiro")
    listaHospedes.add("Eleanor Neves")
    listaHospedes.add("Gabriel Paiva")
    listaHospedes.add("Débora Menezes")
    listaHospedes.add("Michael B Jordan")
    listaHospedes.add("Priscila Gabriel")
    listaHospedes.add("Noelia Vasquez")
    listaHospedes.add("Carla Octaviano Azevedo")
}

fun onStop_cadastro(){

}

fun cadastrar_hospedes(){
    var novo_hospede: String = askQuestion("Cadastro de Hóspede\nPor favor, informe o nome do hóspede")
    listaHospedes.add(novo_hospede)

    println(novo_hospede + " cadastrado com sucesso!")
    println("\n" + listaHospedes.toString())
}

fun pesquisar_hospedes(){
    var pesquisa_hospede: String = askQuestion("Pesquisa de Hóspede\nPor favor, informe o nome do hóspede")


    println("\n" + listaHospedes.toString())
    if (listaHospedes.contains(pesquisa_hospede)){
        println("Encontramos o(s) hóspede(s): ")
        for(element in listaHospedes){
            if (element.contains(pesquisa_hospede)) println(element)
        }
    } else println("Não encontramos um hóspede com esse nome")
}

fun erro_hospedes(){
    println("Por favor, somente digite numeros entre 1 e 3")
}

fun sair_hospede(){
    println("Você deseja sair? s/n")

    var option: String = readln()
    if(option.lowercase() == "s"){
        isCadastroHospedeRunning = false
    } else if(option.lowercase() == "n") {
        //todo
    } else {
        println("Desculpe, mas não compreendi")
        sair()
    }
}

