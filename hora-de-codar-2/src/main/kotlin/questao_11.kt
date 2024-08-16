/*
* Escreva um programa para ler 2 valores inteiros informados pelo usuário
* e uma das seguintes operações a serem executadas (codificada da seguinte
* forma: 1. Adição, 2. Subtração, 3. Divisão, 4. Multiplicação).
* O programa deve calcular e escrever o resultado dessa operação
* sobre os dois valores lidos.
*  */

fun main(){
    var value1 : Int = 0
    var value2 : Int = 0
    var option : Int = 0

    println("Vamos calcular! digite dois valores Inteiros")
    print("valor 1: ")
    value1 = readln().toInt()
    print("valor 2: ")
    value2 = readln().toInt()

    println("Ótimo, os valores escolhidos foram $value1 e $value2.")
    println("Agora escolha a operação aritimética desejada:\n1. Adição\n2. Subtração\n3. Divisão\n4. Multiplicação")
    print("Opção desejada: ")
    option = readln().toInt()

    if(option == 1) println("$value1 + $value1 = " + (value1 + value2))
    else if (option == 2) println("$value1 - $value2 = " + (value1 - value2))
    else if (option == 3) println("$value1 / $value2 = " + (value1 / value2))
    else if (option == 4) println("$value1 * $value2 = " + (value1 * value2))
}