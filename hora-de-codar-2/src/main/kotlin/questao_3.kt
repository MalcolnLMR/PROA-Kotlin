/*
Faça um programa para ler 3 valores (considere que não serão informados valores iguais) e escrever o maior deles.
 */

fun main(){
    print("Informe o primeiro número: ")
    var awnser1 : Double = readln().toDouble()
    print("Informe o segundo número: ")
    var awnser2 : Double = readln().toDouble()
    print("Informe o terceiro número: ")
    var awnser3 : Double = readln().toDouble()

    if (awnser1 > awnser2) {
        if(awnser1 > awnser3) {
            println("$awnser1 é o maior número")
        } else {
            println("$awnser3 é o maior número")
        }
    } else if (awnser2 > awnser3) {
        println("$awnser2 é o maior número")
    } else {
        println("$awnser3 é o maior número")
    }
}