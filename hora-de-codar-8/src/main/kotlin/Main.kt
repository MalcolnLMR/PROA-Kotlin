package org.example

suspend fun main() {
    while (true){
        print("Qual código deseja executar?\n" +
                "1) Agenda\n" +
                "Resposta: ")
        val read = readln()

        when(read) {
            "1" -> startAgenda()
            else -> continue
        }
    }
}