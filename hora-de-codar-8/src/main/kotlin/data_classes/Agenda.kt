package org.example.data_classes

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Agenda(
    @BsonId
    val id: ObjectId,
    val nome: String,
    val endereco: Cep,
    val telefone: String,
)
