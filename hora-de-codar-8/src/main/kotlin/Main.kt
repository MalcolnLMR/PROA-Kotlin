package org.example

import org.example.grade.startGrade

suspend fun main() {
    val database = Database()

    while (true){
        print("Qual código deseja executar?\n" +
                "1) Agenda\n" +
                "2) Grade de Notas\n" +
                "Resposta: ")
        val read = readln()

        when(read) {
            "1" -> startAgenda()
            "2" -> startGrade(database)
            else -> continue
        }
    }
}