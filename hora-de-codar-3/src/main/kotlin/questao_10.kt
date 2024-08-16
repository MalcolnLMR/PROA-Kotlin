/*
* Escreva um programa para imprimir todas as tabuadas de 1 a N. N será informado pelo usuário.
* */

// Para resolução do exercicio, vou assumir que TODAS signifique as tabuadas de 1 a 10
// Assumo isso, pois não faz sentido ser de 1 a Infinito.
fun main(){
    var read : Int = 0

    print("Digite o valor de N: ")
    read = readln().toInt()

    for(i in 1..10){
        println("-- * Tabuada do $i * --")
        for(j in 1..read){
            println("$i * $j = " + (i * j))
        }
    }
}