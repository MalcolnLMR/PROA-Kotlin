import kotlin.reflect.typeOf

/*
Considerando a figura abaixo, escreva um programa para cada forma
que calcule e exiba em tela cada uma de suas respectivas áreas.
O usuário irá informar os valores de cada variável.
*/
fun main(){
    print(  "1. Retângulo\n" +
            "2. Quadrado\n" +
            "3. Losango\n" +
            "4. Trapézio\n" +
            "5. Paralelogramo\n" +
            "6. Triângulo\n" +
            "7. Círculo\n" +
            "Escreva sua opção: ")
    var awnser : Int? = readlnOrNull()?.toInt()

    print("Escreva sua idade: ")
    var age = readlnOrNull()
    println("Olá, $awnser, sua idade é $age")
}

fun retangulo(base: Double, altura: Double): Double{

    return (base * altura)
}

fun quadrado(lado: Double): Double{
    return (lado * lado)
}

fun losango(diagonalMaior: Double, diagonalMenor: Double): Double{
    return ((diagonalMaior * diagonalMenor)/2)
}

fun trapezio(baseMaior: Double, baseMenor: Double, altura: Double): Double{
    return ((baseMaior + baseMenor)*altura)/2
}

fun paralelogramo(base: Double, altura: Double): Double{
    return retangulo(base, altura)
}

fun triangulo(base: Double, altura: Double): Double{
    return losango(base, altura)
}

fun circulo(radio: Double): Double{
    return (Math.PI * (radio * radio))
}