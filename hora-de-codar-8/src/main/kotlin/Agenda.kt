package org.example

import com.mongodb.kotlin.client.coroutine.MongoDatabase
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.bson.types.ObjectId
import org.example.data_classes.Agenda
import org.example.data_classes.Cep
import java.net.HttpURLConnection
import java.net.URL
import kotlin.system.exitProcess

val database = Database()
var db: MongoDatabase? = null
var contatos: MutableList<Agenda>? = null
var newContatos: MutableList<Agenda>? = null
var previewContatos: MutableList<Agenda>? = null

suspend fun startAgenda() {
    db = database.setupConnection()

    if (db == null) exitProcess(404)

    contatos = database.readAgenda(db)
    newContatos = emptyList<Agenda>().toMutableList()
    agenda()
}

suspend fun agenda(){
    refreshContatos()
    println("\nSua agenda tem ${contatos!!.size} contatos")

    var read: String
    while (true){
        println("O que deseja fazer?")
        println("1) Adicionar contato\n" +
                "2) Pesquisar contato\n" +
                "3) Listar contatos (ordem alfabetica)\n" +
                "4) Listar contatos\n" +
                "5) sair")
        print("Resposta: ")
        read = readln()
        when(read){
            "1" -> addContato()
            "2" -> searchContato()
            "3" -> listContatoSorted()
            "4" -> listContato()
            "5" -> quitApp()
            else -> { println("resposta inválida"); continue }
        }
    }
}

fun addContato(){
    var isRunning = true
    var read: String
    //val contatos = emptyList<Agenda>().toMutableList()
    while (isRunning){
        println("Qual o Nome?")
        print("Resposta: ")
        val nome = readln()

        // loop para pegar o CEP
        var cep: Cep?
        while(true){
            println("Qual o CEP?")
            print("Resposta: ")
            read = readln()

            if (read.length != 8) {
                println("formato inválido")
                continue
            }

            cep = getCep(read)
            if (cep == null) {
                println("este cep não existe")
                continue
            }
            break
        }

        // loop para pegar o número
        var telephone: String
        while(true){
            println("Qual o telefone? (somente números)")
            println("exemplo: 11989591230")
            print("Resposta: ")
            read = readln()

            if (read.length != 11 && read.length != 10) {
                println("formato inválido")
                continue
            }

            telephone = read
            break
        }

        newContatos!!.add(
            Agenda(
                id = ObjectId(),
                nome = nome,
                endereco = cep!!,
                telefone = telephone
            )
        )

        println("Adicionar novo contato?")
        print("Resposta (s/n): ")
        read = readln()

        if (read[0].lowercase() == "s"){
            continue
        }

        isRunning = false
    }
}

fun listContato(){
    var i = 0
    previewContatos = (contatos!! + newContatos!!).toMutableList()
    for (contato in previewContatos!!){
        i++
        println(
            "nome: ${contato.nome}\n" +
            "cep: ${contato.endereco.cep}\n" +
            "logadouro: ${contato.endereco.logradouro}\n" +
            "estado: ${contato.endereco.uf}\n" +
            "telefone: ${contato.telefone}\n"
        )

        if (i >= 10){
            break
        }
    }
}

fun searchContato(){
    print("Nome do contato: ")
    val read = readln()
    println(contatos!!.any { it.nome.contains(read) })
}

fun listContatoSorted(){
    var i = 0
    previewContatos = (contatos!! + newContatos!!).toMutableList()
    previewContatos!!.sortBy { it.nome }
    for (contato in previewContatos!!){
        i++
        println(
            "nome: ${contato.nome}\n" +
                    "cep: ${contato.endereco.cep}\n" +
                    "logadouro: ${contato.endereco.logradouro}\n" +
                    "estado: ${contato.endereco.uf}\n" +
                    "telefone: ${contato.telefone}\n"
        )

        if (i >= 10){
            break
        }
    }
}

@OptIn(ExperimentalSerializationApi::class)
fun getCep(cep : String) : Cep? {
    if (cep.length != 8) return null
    val url = URL("https://viacep.com.br/ws/$cep/json/")
    val urlConnection = url.openConnection() as HttpURLConnection
    val content = urlConnection.inputStream.bufferedReader().readText()

    val json = Json { ignoreUnknownKeys = true }
    val response: Cep
    try {
        response = json.decodeFromString<Cep>(content)
    } catch (_: kotlinx.serialization.MissingFieldException){
        return null
    }

    return response
}

suspend fun quitApp(){
    println("Desligando programa de agenda!")
    updateContatos()
    exitProcess(0)
}

suspend fun updateContatos(){
    for (contato:Agenda in newContatos!!){
        database.addAgenda(db, contato)
    }
    refreshContatos()
}

suspend fun refreshContatos(){
    contatos = database.readAgenda(db)
    newContatos = emptyList<Agenda>().toMutableList()
}




