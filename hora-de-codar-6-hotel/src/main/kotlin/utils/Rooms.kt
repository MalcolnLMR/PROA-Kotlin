package utils

// A specified class to work on managing rooms
class Rooms() {

    // Declarations
    private var totalRooms: Int = 20

    private var roomsAvailability: MutableList<Boolean> = mutableListOf()
    private var roomsPrice: MutableList<Double> = mutableListOf()
    private var roomsTotalDays: MutableList<Int> = mutableListOf()
    private var roomsRemainingDays: MutableList<Int> = mutableListOf()

    init {
        for (i in 0..<totalRooms){
            roomsAvailability.add(true)
            roomsPrice.add(0.0)
            roomsTotalDays.add(0)
            roomsRemainingDays.add(0)
        }
    }

    fun isRoomAvailable(roomNumber : Int) : Boolean{
        return roomsAvailability[roomNumber-1]
    }

    fun getRoomAvailabilityText(): String{
        var response:String = ""
        for ((i, room) in roomsAvailability.withIndex()){
            response += " • Quarto ${i+1} está ${if (room) "LIVRE" else "OCUPADO"}\n"
        }
        return response
    }

    fun getRoomPrice(index: Int): Double?{
        if (roomsAvailability[index]) return null
        return roomsPrice[index]
    }

    fun addClient(roomNumber: Int, roomPrice: Double, roomDays: Int): Boolean{
        if (!(Numbers.isNatural(roomPrice) && Numbers.isNatural(roomDays))) return false
        if (!isRoomAvailable(roomNumber)) return false

        val roomIndex = roomNumber-1
        roomsAvailability[roomIndex] = false
        roomsTotalDays[roomIndex] = roomDays
        roomsPrice[roomIndex] = roomPrice
        return true
    }




}