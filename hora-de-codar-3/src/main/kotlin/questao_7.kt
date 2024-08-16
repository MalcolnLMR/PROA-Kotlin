/*
* Escreva um algoritmo para ler as notas de avaliações de um aluno,
* calcule e imprima a média (simples) desse aluno. Só devem ser
* aceitos valores válidos durante a leitura (0 a 10) para cada nota.
* São 6 notas ao total. Caso o valor informado para qualquer uma das
* notas esteja fora do limite estabelecido, deve ser solicitado um
* novo valor ao usuário.
* */

fun main(){
    var gradesArray : Array<Double> = arrayOf(0.0,0.0,0.0,0.0,0.0,0.0)
    var read : Double = 0.0
    println("calculadora de média para aluno")

    for(index in 0..5) {
        print("Digite a nota " + (index + 1) + ": ")
        read = readln().toDouble()
        while (read < 0 || read > 10) {
            print("Valor Inválido. Tente novamente: ")
            read = readln().toDouble()
        }
        gradesArray[index] = read
    }

    println("A média é " + (gradesArray.sum() / gradesArray.size))
}