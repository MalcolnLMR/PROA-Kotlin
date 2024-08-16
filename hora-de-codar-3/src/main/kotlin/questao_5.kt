/*
* Faça um algoritmo que calcule e escreva a média aritmética dos
* dois números inteiros informados pelo usuário e todos os números
* inteiros entre eles. Considere que o primeiro sempre será menor
* que o segundo.
* */

fun main(){
    var init : Int = 0
    var final : Int = 0
    var sum : Int = 0

    print("Digite o valor inicial: ")
    init = readln().toInt()
    var count : Int = init

    while (final <= init){
        print("O Valor deve ser maior que $init\nDigite o valor inicial: ")
        final = readln().toInt()
    }

    while (count <= final){
        sum += count
        count++
    }

    println("A média aritimética entre $init e $final é " + (sum / (final - init)))
}