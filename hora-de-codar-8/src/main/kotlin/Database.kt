package org.example

import com.mongodb.MongoException
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import kotlinx.coroutines.flow.count
import org.bson.BsonInt64
import org.bson.Document
import org.bson.types.ObjectId
import org.example.data_classes.Agenda
import org.example.data_classes.Grade

class Database {

    private val client: MongoClient
    private val databaseName = "hora_de_codar_8"
    private val db: MongoDatabase

    init {
        /* Não é correto colocar as credenciais do banco de dados no código
         * MAS, é um cluster gratuito para experimentar e estudar, então caso
         * tente executar isso aqui, e o servidor estiver offline, entre em
         * contato comigo, que atualizarei o link para outro servidor de testes
         */
        val connectionString = "mongodb+srv://dbAdmin:admin@cluster0.wqv6y.mongodb.net/"
        client = MongoClient.create(connectionString)
        db = client.getDatabase(databaseName)
    }

    suspend fun setupConnection(): MongoDatabase? {
        return try {
            val command = Document("ping", BsonInt64(1))
            db.runCommand(command)
            println("Conectado com sucesso ao cluster do MongoDB!")
            db
        } catch (me: MongoException) {
            System.err.println(me)
            null
        }

    }

    suspend fun listAllCollection(database: MongoDatabase?) {
        if (database == null) return

        val count = database.listCollectionNames().count()
        println("Numero de coleções: $count")

        print("A lista de coleções neste banco de dados são -----------> ")
        database.listCollectionNames().collect { print("\n • $it") }
    }

    suspend fun addAgenda(database: MongoDatabase?, toAdd: Agenda) {
        if (database == null) return

        val collection = database.getCollection<Agenda>(collectionName = "agenda")
        val item = Agenda(
            id = ObjectId(),
            nome = toAdd.nome,
            endereco = toAdd.endereco,
            telefone = toAdd.telefone
        )

        collection.insertOne(item).also {
            println("Contado adicionado na agendo, com o Id - ${it.insertedId}")
        }
    }

    suspend fun addGrade(database: MongoDatabase?, toAdd: Grade) {
        if (database == null) return

        val collection = database.getCollection<Grade>(collectionName = "grade")
        val item = Grade(
            id = ObjectId(),
            nome = toAdd.nome,
            notas = toAdd.notas
        )

        collection.insertOne(item).also {
            println("Contado adicionado na grade, com o Id - ${it.insertedId}")
        }
    }

    suspend fun readAgenda(database: MongoDatabase?): MutableList<Agenda>? {
        if (database == null) return null

        var contatos = emptyList<Agenda>().toMutableList()
        val collection = database.getCollection<Agenda>(collectionName = "agenda")
        collection.find<Agenda>().collect {
            contatos.add(it)
        }
        return contatos
    }

    suspend fun readGrade(database: MongoDatabase?): MutableList<Grade>? {
        if (database == null) return null

        var dbList = emptyList<Grade>().toMutableList()
        val collection = database.getCollection<Grade>(collectionName = "grade")
        collection.find<Grade>().collect {
            dbList.add(it)
        }
        return dbList
    }


}