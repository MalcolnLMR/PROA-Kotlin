/*
* Escreva um programa em que o usuário informe dois números. Então escreva em tela o maior deles.
* */

fun main(){
    print("Informe o primeiro número: ")
    var awnser1 : Double = readln().toDouble()
    print("Informe o segundo número: ")
    var awnser2 : Double = readln().toDouble()

    if (awnser2 < awnser2){
        println("$awnser2 é maior que $awnser1")
    } else if (awnser2 != awnser1){
        println("$awnser1 é maior que $awnser2")
    } else {
        println("Você digitou numeros iguais! ($awnser2)")
    }
}