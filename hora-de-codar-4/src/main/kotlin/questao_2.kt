/*
* Crie uma array de planetas que inclua "Terra", "Marte", "Plutão", "Vênus",
* "Júpiter", "Saturno"  e, em seguida, peça ao usuário para digitar o nome de um planeta.
* Verifique se o planeta que o usuário informou está na array e informe ao usuário.
* */


/*
* NOTA: a lista de planetas está incompleta, e como o enunciado pede que a list
* "Inclua" tais planetas (e não que TENHA SOMENTE), tomei a liberdade de completar a lista
*
* ps. como plutão está na lista, também adicionei os outros planetas anões do sistema solar
* */
fun main(){
    var planetsArray : Array<String> = arrayOf("mercúrio", "vênus","terra", "marte", "júpiter", "saturno", "urano",
        "netuno","plutão", "ceres", "haumea", "makemake", "éris")
    var read : String = ""

    print("Digite um planeta: ")
    read = readln()

    if(read.lowercase() in planetsArray) println("$read está na lista de planetas!")
    else println("$read não está na lista de planetas :c")
}