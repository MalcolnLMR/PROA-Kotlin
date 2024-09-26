package org.example

import org.bson.types.ObjectId
import org.example.data_classes.Agenda
import org.example.data_classes.Endereco

suspend fun main() {
    val database = Database()
    val db = database.setupConnection()
    database.listAllCollection(db)

    val endereco = Endereco(
        logadouro = "Avenida Paulista",
        numero = "1000",
        bairro = "Bela Vista",
        cidade = "São Paulo",
        estado = "SP",
        cep = "01310100"
    )
    val item = Agenda(
        id = ObjectId(),
        nome = "Malcoln Lucas",
        telefone = "+55-11-9-8759-5071",
        endereco = endereco
    )

    database.addAgenda(db, item)
}