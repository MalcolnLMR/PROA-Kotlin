class Hotel {
    // Declarations
    var rooms: BooleanArray = BooleanArray(20)

    constructor(main: MainApplication){
        main.onStart += ::onStart
    }

    fun onStart(){
        rooms.fill(true)
    }

}