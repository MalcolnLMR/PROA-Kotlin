// Global Variables
var listaQuartos: BooleanArray = BooleanArray(20)
var isReservarQuartoRunning: Boolean = false


fun main_reservarQuarto(){
    onStart_reservar()

    while (isReservarQuartoRunning){

    }

    onStop_reservar()
}

fun onStop_reservar() {
    TODO("Not yet implemented")
}

fun onStart_reservar(){
    listaQuartos.fill(true)
}