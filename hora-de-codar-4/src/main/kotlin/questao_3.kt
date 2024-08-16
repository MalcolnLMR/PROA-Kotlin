/*
* Vamos criar uma lista de compras.
* Crie uma array de frutas, exiba-a ao usuário e, em seguida,
* peça ao usuário para digitar o nome de uma das frutas.
*
* Caso a fruta esteja no array, remova-a e exiba a mensagem
* "Fruta foi retirada da lista".
*
* Peça novamente para o usuário digitar o nome de uma fruta
* para ser removida.
*
* Sempre que o usuário procurar por uma fruta que não está
* no array exiba a mensagem "Fruta indisponível no nosso mercado".
*
* Quando o array não possuir mais itens dentro de si,
* escreva "Lista de compras finalizada".
* */

// Não compreendi o "Peça novamento para o usuário digitar o nome
// de uma fruta para ser removida", Logo, não está implementado
fun main(){
    var fruitsArray : ArrayList<String> = arrayListOf("maça", "abacaxi", "pêra", "abacate", "banana")
    var read : String = ""

    while (fruitsArray.isNotEmpty()){
        println("Frutas disponíveis: ${fruitsArray.toList()}"
            .replace("[", "\n • ")
            .replace("]", "")
            .replace(", ", "\n • "))

        print("\nQual fruta está pegando?\nResposta: ")
        read = readln().lowercase()

        if(read in fruitsArray) {
            println("\n\n$read foi removida da lista!")
            fruitsArray.remove(read)
        }
        else println("Fruta indisponível no nosso mercado")
    }

    println("Lista de compras finalizada")
}