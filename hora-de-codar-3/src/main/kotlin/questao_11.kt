/*
* Escreva um programa em que o usuário informe 10 valores e escreva quantos
* desses valores lidos estão entre os números 24 e 42 (incluindo os valores 24 e 42)
* e quantos deles estão fora deste intervalo.
* */

fun main(){
    var inRangeCounter : Int = 0
    var outRangeCounter : Int = 0
    var read : Double = 0.0

    for(i in 0..9){
        print("Digite um número: ")
        read = readln().toDouble()
        if(read in 24.0..42.0) inRangeCounter++
        else outRangeCounter++
    }

    println("$inRangeCounter estavam dentro do valor e $outRangeCounter estavam fora")
}