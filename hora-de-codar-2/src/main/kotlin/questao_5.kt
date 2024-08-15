/*
Faça um programa que leia 6 valores informados pelo usuário, calcule,
 exiba os números informados e escreva a média aritmética desses valores lidos.
 */

fun main(){
    var awnserArray : Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0)

    print("Informe o primeiro número: ")
    awnserArray[0] = readln().toDouble()
    print("Informe o segundo número: ")
    awnserArray[1] = readln().toDouble()
    print("Informe o terceiro número: ")
    awnserArray[2] = readln().toDouble()
    print("Informe o quarto número: ")
    awnserArray[3] = readln().toDouble()
    print("Informe o quinto número: ")
    awnserArray[4] = readln().toDouble()
    print("Informe o sexto número: ")
    awnserArray[5] = readln().toDouble()

    var sum : Double = 0.0
    for (num in awnserArray){
        sum += num
    }
    var result : Double = sum / 6
    println("a média aritimética é $result")
}