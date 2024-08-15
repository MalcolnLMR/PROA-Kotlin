/*
Escreva um programa em que o usuário informe o seu nome
e em seguida o programa perguntará a idade do usuário.
Agora o programa deve exibir a mensagem
"Olá, [NomeDoUsuario], sua idade é [idade]".
 */
fun main(){
    print("Escreva seu nome: ")
    var username = readlnOrNull()
    print("Escreva sua idade: ")
    var age = readlnOrNull()
    println("Olá, $username, sua idade é $age")
}