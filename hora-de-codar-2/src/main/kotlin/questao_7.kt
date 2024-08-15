/*
Faça um programa que leia 6 números que o usuário vai informar.
Todos os números lidos com valor inferior a 72 devem ser somados.
Escreva o valor final da soma efetuada e também todos valores que o usuário informou.
*/

fun main(){
    var arrayAwnsers : Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0)

    for(i in 1..6){
        print("digite")
    }
    println()

}

fun check(number : Double) : Boolean{
    return (number < 72)
}