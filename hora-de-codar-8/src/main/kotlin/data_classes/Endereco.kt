package org.example.data_classes

import org.bson.codecs.pojo.annotations.BsonProperty

data class Endereco(
    val logadouro: String,
    val numero: String,
    val bairro: String,
    val cidade: String,
    val estado: String,
    @BsonProperty("CEP")
    val cep: String
)
