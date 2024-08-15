/*
Escreva um programa em que o usuário informe o seu nome
e exiba a mensagem "Olá, [NomeDoUsuario]".
*/
fun main(){
    print("Escreva seu nome: ")
    var username = readlnOrNull()
    println("Olá, $username")
}