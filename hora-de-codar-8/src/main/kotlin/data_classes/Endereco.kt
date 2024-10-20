package org.example.data_classes

import kotlinx.serialization.Serializable
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

@Serializable
data class Cep(
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val unidade: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val estado: String,
    val regiao: String,
    val ibge: String,
    val gia: String,
    val ddd: String,
    val siafi: String
)
