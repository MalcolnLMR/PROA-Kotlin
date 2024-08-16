/*
* Crie uma bomba relógio (usando somente código - para deixar claro!)
* cuja contagem regressiva vá de 30 a 0. Utilize "document.write" para
* escrever em tela e no final da repetição escreva "EXPLOSÃO".
* */

fun main(){
    var count : Int = 30
    println("$count segundos restantes")
    while(count > 0){
        Thread.sleep(1000)
        count--
        println("$count segundos restantes")
    }
    println("EXPLOSÃO")
}

