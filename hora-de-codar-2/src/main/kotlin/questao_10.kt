/*
* Tendo como entrada a altura e o sexo (codificado da seguinte forma: 1: feminino 2: masculino)
* de uma pessoa, construa um programa que calcule e imprima seu peso ideal,
* utilizando as seguintes fórmulas:
* h: (72.7 * h) - 58
* m: (62.1 * h) - 44.7
* */

fun main(){
    var height : Double = 0.0
    var gender : Int = 0

    var x = 0 

    println("Vamos descobrir seu peso ideal!")
    print("primeiro digite seu gênero:\n1. feminino\n2. masculino\nResposta: ")
    gender = readln().toInt()

    print("Agora precisamos saber a sua altura (em metros): ")
    height = readln().toDouble()

    if(gender == 1) println("seu peso ideal é " + ((height * 72.7) - 58))
    else println("seu peso ideal é " + ((height * 62.1) - 44.7))
}
