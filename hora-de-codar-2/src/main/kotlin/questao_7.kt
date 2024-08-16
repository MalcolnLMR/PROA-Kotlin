/*
Faça um programa que leia 6 números que o usuário vai informar.
Todos os números lidos com valor inferior a 72 devem ser somados.
Escreva o valor final da soma efetuada e também todos valores que o usuário informou.
*/

fun main(){
    var arrayAwnsers : Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0)
    var sum : Double = 0.0
    var read : Double = 0.0

    for(i in 0..5){
        print("digite um número: ")
        read = readln().toDouble()
        if (read < 72) sum += read
        arrayAwnsers[i] = read
    }

    println("a soma dos valores abaixo de 72 é $sum")
    println("os valores digitados foram: ${arrayAwnsers.toList()}")
}