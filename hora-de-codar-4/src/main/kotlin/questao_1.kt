/*
* Crie um programa onde o usuário possa cadastrar estudantes sem limites,
* e, em seguida, Se o usuário digitar "PARE" o programa deve exibir a
* quantidade de estudantes cadastrados e a lista com cada um deles.
* */

fun main(){
    var studentsArray : Array<String> = arrayOf()
    var read : String = ""

    print("Digite o aluno a ser adicionado: ")
    read = readln()
    while (read.lowercase() != "pare"){
        studentsArray += read.lowercase().replaceFirstChar { read[0].uppercaseChar() }
        print("Digite o aluno a ser adicionado: ")
        read = readln()
    }

    println("A quantidade de alunos cadastrados foram: " + (studentsArray.size))
    println("Lista de alunos cadastrados")
    for (student in studentsArray){
        println("Nome: $student")
    }
}