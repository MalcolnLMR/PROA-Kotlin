package org.example.data_classes

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Grade(
    @BsonId
    val id: ObjectId,
    val nome: String,
    val notas: List<Double>
)
