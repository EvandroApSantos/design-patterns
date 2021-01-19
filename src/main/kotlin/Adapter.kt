interface Spacecraft {
    fun sendToSpace(payload: String)
}

class CargoSpacecraft: Spacecraft {
    private val adapter = SpacecraftAdapter()

    override fun sendToSpace(payload: String) {
        when (payload) {
            "satellite" -> println("Sending a satellite to space")
            //Comment/uncomment the following "else's" and run unit tests to check adapter in action!
            //else -> println("Sorry. I cannot send $payload to space.")
            else -> adapter.sendToSpace(payload)
        }
    }
}

class SpacecraftAdapter: Spacecraft {
    override fun sendToSpace(payload: String) {
        when (payload) {
            "humans" -> CrewDragonSpacecraft().sendToSpace()
            "rover" -> AtlasVSpacecraft().sendToSpace()
            else -> println("Sorry. I cannot send $payload to space.")
        }
    }
}

interface AdvancedSpacecraft {
    fun sendToSpace()
}

class CrewDragonSpacecraft: AdvancedSpacecraft {
    override fun sendToSpace() {
        println("Sending humans to ISS")
    }
}

class AtlasVSpacecraft: AdvancedSpacecraft {
    override fun sendToSpace() {
        println("Sending a rover to Mars")
    }
}