/*
Faça um programa que leia 3 valores informados pelo usuário
(considere que não serão informados valores iguais) e escrever a soma dos 2 maiores.
 */

fun main(){
    var awnserArray : Array<Double> = arrayOf(0.0,0.0,0.0)

    print("Informe o primeiro número: ")
    awnserArray[0] = readln().toDouble()
    print("Informe o segundo número: ")
    awnserArray[1] = readln().toDouble()
    print("Informe o terceiro número: ")
    awnserArray[2] = readln().toDouble()

    awnserArray.sort()
    var result : Double = awnserArray[1] + awnserArray[2]
    println("$result é o resultado da soma")
}