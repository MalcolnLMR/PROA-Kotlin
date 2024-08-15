/*
Faça um programa que leia um valor informado pelo usuário e diga se o valor informado é positivo, negativo ou zero.
 */

fun main(){
    print("Informe um número: ")
    var awnser : Double = readln().toDouble()

    if(awnser > 0) println("$awnser é positivo")
    else if(awnser < 0) println("$awnser é negativo")
    else println("$awnser é zero")
}