Bem-vindos(as) ao tutorial super rápido pra fazer a tarefa “[Kotlin] Hora de Codar” pro dia 19/08/2024

primeiro quero começar lembrando os conceitos que vamos precisar


## Váriavel
• Definição objetiva
   É um recurso usado para guardar informações que podem ser alteradas durante o código
• Explicação detalhada
   Funciona como um copo, ele pode ter vário liquidos diferentes, as vezes até objetos, assim como também pode estar vazio, o copo está funcionando como um local para armazenar informação, assim como uma variável.

### Definindo uma variável em portugol:
```portugol
cadeira texto_qualquer = "Olá Mundo"
caracter caractere_qualquer = 'A'
inteiro numero_inteiro_qualquer = 0 
real numero_qualquer = 3.14
```
*O tipo **Vazio** será explicado em funções*

### Definindo uma variável em kotlin:
```kotlin
var texto_qualquer: String = "Olá Mundo"
var caractere_qualquer: Char = 'A'
var numero_inteiro_qualquer: Int = 3
var numero_qualquer: Double = 3.14
var numero_qualquer_menos_preciso: Float = 3.14f

val qualquer_coisa = "Eu sou um Valor que não pode ser alterado!"
var qualquer_coisa = "Eu sou um valor que PODE ser alterado!"
```
Como declarar a variável: 
var [nome da variavel] : [tipo da variavel] = [valor da variavel]
O tipo é opcional apenas quando você determina um valor para a variável enquando declara ela.

*Para ajudar a lembrar de qual tipo pode ser alterado, pense em **VAR**íavel*

### Semelhanças
• Tipos
Cadeia → String
Caracter → Char
Inteiro → Int
Real → Double ou Float
Vazio → void (exclusivo do Java)

• Funções
escreva → print
leia → readln

## Exercícios 1 e 2 em Kotlin
### Exercício 1: Kotlin
Enunciado: Escreva um programa que crie uma variável chamada "nome_do_carro" e atribua-a um valor "Fusca". Exiba-a ao usuário.
```kotlin
fun main() {
    val nome_do_carro = "Fusca"
    println(nome_do_carro)
}
```
*O que é o "fun main() {}"?*
Em poucas palavras, é a função principal onde você irá escrever seu código. Serve o mesmo propósito deste trecho de código em portugol:
```portugol
programa {
    funcao inicio(){

    }
}
```
Ou deste trecho de código em java:
```java
public class Test {
	public static void main(String[] args){

			
	}
}
```

*Qual a diferença do print para o println?*
O println pula a linha depois de escrever o texto, de maneira simples, você pode escrever das duas formas abaixo:
`println(nome_do_carro)` = `print(nome_do_carro + "\n")`

### Exercício 2: Kotlin
Enunciado: Escreva um programa em que o usuário informe o seu nome e exiba a mensagem "Olá, [NomeDoUsuario]".
```kotlin
fun main(){
    print("Escreva seu nome: ")
    var username = readlnOrNull()
    println("Olá, $username")
}
```
*O que é o "$" no meio do texto?*
O Kotlin suporta adicionar as variáveis direto no texto, pra ajudar na hora de fazer o print e editar uma String.
`print("Olá $username")` = `escreva("Olá, ", username)`
Lembrando que esta forma de escrever o texto não é obrigatória, ele também suporta concatenação (adicionar uma String em outra), e escrever igual ao portugol, utilizando virgulas

## Aviso Importante!
Quando estiver fazendo as leituras com o `readln()`, lembre que ele retorna SEMPRE como String (texto)! Caso queira alterar o texto para número, você deve converter usando: `readln().toDouble()` ou `readln().toInt()`
