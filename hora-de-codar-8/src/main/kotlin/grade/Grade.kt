package org.example.grade

import com.mongodb.kotlin.client.coroutine.MongoDatabase
import org.bson.types.ObjectId
import org.example.Database
import org.example.data_classes.Grade
import kotlin.system.exitProcess

var databaseGrade: Database? = null
var dbGrade: MongoDatabase? = null
var dbData : MutableList<Grade>? = emptyList<Grade>().toMutableList()
var dbNewData : MutableList<Grade>? = emptyList<Grade>().toMutableList()
var dbPreviewData : MutableList<Grade>? = emptyList<Grade>().toMutableList()

suspend fun startGrade(database: Database) {
    databaseGrade = database
    dbGrade = databaseGrade!!.setupConnection()

    if (dbGrade == null) exitProcess(404)

    dbData = databaseGrade!!.readGrade(dbGrade)
    grade()
}

suspend fun grade(){
    refresh()
    println("\nSua agenda tem ${dbData!!.size} contatos")

    var read: String
    while (true){
        println("O que deseja fazer?")
        println("1) Cadastrar\n" +
                "2) Pesquisar\n" +
                "3) Listar\n" +
                "4) sair")
        print("Resposta: ")
        read = readln()
        when(read){
            "1" -> add()
            "2" -> search()
            "3" -> list()
            "4" -> quitApp()
            else -> { println("resposta inválida"); continue }
        }
    }
}

fun add(){
    var isRunning = true
    var read: String

    while (isRunning){
        println("Qual o Nome?")
        print("Resposta: ")
        val nome = readln()

        // loop para pegar o número
        val doubleList = emptyList<Double>().toMutableList()
        while(true){
            println("Qual a nota dele?")
            println("exemplo: 8.0")
            print("Resposta: ")
            read = readln()
            var readDouble: Double?

            try {
                readDouble = read.toDouble()
                doubleList.add(readDouble)
                println(doubleList)
            } catch (_: NumberFormatException){
                println("Formato inválido")
                continue
            }

            println("Adicionar outra nota?")
            print("Resposta (s/n): ")
            read = readln()
            if (read == "" || read[0].lowercase() == "s") continue

            break
        }

        dbNewData!!.add(
            Grade(
                id = ObjectId(),
                nome = nome,
                notas = doubleList
            )
        )

        isRunning = false
    }
}

fun list(){
    dbPreviewData = (dbData!! + dbNewData!!).toMutableList()
    for (data in dbPreviewData!!){
        printData(data)
    }
}

fun printData(data: Grade){
    println(
        "nome: ${data.nome}\n" +
        "notas: ${data.notas}\n" +
        "status: ${if ((data.notas.sum()/data.notas.size) >= 5) "Aprovado" else "Reprovado"}\n"
    )
}

fun search(){
    print("Nome do contato: ")
    val read = readln()
    dbPreviewData = (dbData!! + dbNewData!!).toMutableList()
    if (dbPreviewData!!.any { it.nome.contains(read) }){
        dbPreviewData!!.find { it.nome.contains(read) }?.let { printData(it) }
    } else {
        println("Nada encontrado")
    }
}

suspend fun quitApp(){
    println("Desligando programa de agenda!")
    update()
    exitProcess(0)
}

suspend fun update(){
    for (data:Grade in dbNewData!!){
        databaseGrade!!.addGrade(dbGrade, data)
    }
    refresh()
}

suspend fun refresh(){
    dbData = databaseGrade!!.readGrade(dbGrade)
    dbNewData = emptyList<Grade>().toMutableList()
}