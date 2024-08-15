/*
Considerando a figura abaixo, escreva um programa para cada forma
que calcule e exiba em tela cada uma de suas respectivas áreas.
O usuário irá informar os valores de cada variável.
*/
// Global Variables
var x: Double = 0.0
var y: Double = 0.0
var h: Double = 0.0

fun main(){
    print(  "Escolha um número dentre 1 a 7:\n" +
            "1. Quadrado\n" +
            "2. Retângulo\n" +
            "3. Paralelogramo\n" +
            "4. Losango\n" +
            "5. Triângulo\n" +
            "6. Trapézio\n" +
            "7. Círculo\n" +
            "Escreva sua opção: ")
    var awnser : Int = readln().toInt()

    var result : Double = when (awnser) {
        1 -> quadrado()
        2 -> retangulo()
        3 -> paralelogramo()
        4 -> losango()
        5 -> triangulo()
        6 -> trapezio()
        7 -> circulo()
        else -> {0.0}
    }

    println("resultado da area: $result")
}

fun getOneVariable(){
    print("Digite o valor: ")
    x = readln().toDouble()
}

fun getTwoVariables(){
    print("Digite o primeiro valor: ")
    x = readln().toDouble()
    print("Digite o segundo valor: ")
    y = readln().toDouble()
}

fun getThreeVariables(){
    print("Digite o primeiro valor: ")
    x = readln().toDouble()
    print("Digite o segundo valor: ")
    y = readln().toDouble()
    print("Digite o terceiro valor: ")
    h = readln().toDouble()
}

fun retangulo(): Double{
    getTwoVariables()
    return (x * y)
}

fun quadrado(): Double{
    getOneVariable()
    return (x * x)
}

fun losango(): Double{
    getTwoVariables()
    return ((x * y)/2)
}

fun trapezio(): Double{
    getThreeVariables()
    return ((x + y)*h)/2
}

fun paralelogramo(): Double{
    getTwoVariables()
    return (x * y)
}

fun triangulo(): Double{
    getTwoVariables()
    return (x * y)
}

fun circulo(): Double{
    getOneVariable()
    return (Math.PI * (x * x))
}