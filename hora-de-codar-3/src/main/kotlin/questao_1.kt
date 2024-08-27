/*

* * Escreva um algoritmo para ler 2 valores informados pelo usuário e se o segundo
* valor informado for igual ou menor que ZERO, deve ser lido um novo valor.
* Ou seja, para o segundo valor não pode ser aceito o valor zero, nem um valor negativo.
* O seu programa deve imprimir o resultado da divisão do primeiro valor lido pelo segundo valor.
* */

fun main(){
    var value1 : Double = 0.0
    var value2 : Double = 0.0

    println("Digite o primeiro valor: ")
    value1 = readln().toDouble()

    var whileCounter : Int = 0
    while (value2 <= 0.0){
        if (whileCounter != 0) println("O valor deve ser maior que zero")
        print("Digite o segundo valor: ")
        value2 = readln().toDouble()
        whileCounter++
    }

    println("O resultado da divisão entre $value1 e $value2 é " + (value1 / value2))
}