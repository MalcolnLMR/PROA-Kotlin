/*
* Escreva um programa que calcule a média de quatro números informados pelo usuário,
* mas somente se esses números forem maiores que 0 e menores que 10. No final,
* se a média for maior que cinco o usuário receberá uma mensagem "Você passou no teste".
* Em qualquer outra situação, ele receberá uma mensagem de "tente novamente"
*  */

fun main(){
    var sum : Double = 0.0
    var read : Double = 0.0
    var sumCount : Int = 0

    for(i in 0..3){
        print("digite um número: ")
        read = readln().toDouble()
        if (read > 0 && read < 10) {
            sum += read
            sumCount++
        }
    }

    if((sum/sumCount) > 5){
        println("Você passou no teste")
    } else {
        println("tente novamente")
    }
}