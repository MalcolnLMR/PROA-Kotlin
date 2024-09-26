package org.example

import com.mongodb.kotlin.client.coroutine.MongoDatabase
import org.bson.types.ObjectId
import org.example.data_classes.Agenda
import org.example.data_classes.Endereco

val database = Database()
var db: MongoDatabase? = null

suspend fun main() {
    db = database.setupConnection()
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

suspend fun agenda(){
    var contatos = database.countAgenda(db) ?: return
    println("Sua agenda tem $contatos contatos")

    var isRunning = true
    var read: String
    while (isRunning){
        println("O que deseja fazer?")
        println("1) Adicionar contato\n" +
                "2) Pesquisar contato\n" +
                "3) Listar contatos (ordem alfabetica)\n" +
                "4) Listar contatos\n" +
                "5) sair")
        read = readln()
        when(read){

        }

    }
}