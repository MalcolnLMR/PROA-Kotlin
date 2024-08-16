/*
* Faça um algoritmo que calcule e escreva a média aritmética dos números inteiros entre
* 15 (inclusive) e 100 (inclusive).
*  */

fun main(){
    var init : Int = 15
    var final : Int = 100
    var count : Int = init
    var sum : Int = 0

    while (count <= final){
        sum += count
        count++
    }

    println("A média aritimética entre $init e $final é " + (sum / (final - init)))
}