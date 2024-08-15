/*
Faça um programa que receba quatro valores informados pelo usuário,
mas informe somente o primeiro, o último e o maior de todos eles
(considere que todos os números informados serão diferentes)
 */

fun main(){
    var awnserArray : Array<Double> = arrayOf(0.0,0.0,0.0,0.0)
    var result1 : Double = 0.0
    var result2 : Double = 0.0
    var result3 : Double = 0.0

    print("Informe o primeiro número: ")
    awnserArray[0] = readln().toDouble()
    result1 = awnserArray[0]
    print("Informe o segundo número: ")
    awnserArray[1] = readln().toDouble()
    print("Informe o terceiro número: ")
    awnserArray[2] = readln().toDouble()
    print("Informe o quarto número: ")
    awnserArray[3] = readln().toDouble()
    result2 = awnserArray[3]
    awnserArray.sort()
    result3 = awnserArray[3]

    println("o primeiro foi: $result1 \no ultimo foi: $result2\no maior é: $result3")
}