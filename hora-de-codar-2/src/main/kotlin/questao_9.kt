import java.time.LocalDate

/*
* Escreva um programa para ler o ano de nascimento de uma pessoa e escrever
* uma mensagem que diga se ela poderá ou não votar este ano
* (não é necessário considerar o mês em que ela nasceu).
* */

fun main(){
    var year : Int = 0
    var currentYear = LocalDate.now().year

    println("Vamos descobrir se você pode votar esse ano!")
    print("Digite o ano de seu nascimento (yyyy): ")
    year = readln().toInt()

    if((currentYear - year) >= 16){
        println("Você já pode votar!")
    } else {
        println("Você ainda não pode votar")
    }
}