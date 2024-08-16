/*
* Ler um valor N e imprimir todos os valores inteiros entre 1 (inclusive) e N (inclusive).
* Considere que o N será sempre maior que ZERO. N é um valor informado pelo usuário
* */

fun main(){
    var read : Int = 0
    var count : Int = 1

    print("Digite o valor de N: ")
    read = readln().toInt()

    while(count < (read + 1)){
        println(count)
        count++
    }
}