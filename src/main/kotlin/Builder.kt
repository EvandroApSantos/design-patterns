import model.Airplane
import model.Spacecraft

interface Builder {
    fun setName(name: String): Builder
    fun setManufacturer(manufacturer: String): Builder
    fun setEngineName(engineName: String): Builder
    fun setSeats(seats: Int): Builder
    fun setPayloadCapacity(capacity: String): Builder
    fun getResult(): Any
}

class SpacecraftBuilder: Builder {
    private val spacecraft: Spacecraft = Spacecraft()

    override fun setName(name: String): SpacecraftBuilder {
        spacecraft.name = name
        return this
    }

    override fun setManufacturer(manufacturer: String): SpacecraftBuilder {
        spacecraft.manufacturer = manufacturer
        return this
    }

    override fun setEngineName(engineName: String): SpacecraftBuilder {
        spacecraft.engineName = engineName
        return this
    }

    override fun setSeats(seats: Int): SpacecraftBuilder {
        spacecraft.seats = seats
        return this
    }

    override fun setPayloadCapacity(capacity: String): SpacecraftBuilder {
        spacecraft.payloadCapacity = capacity
        return this
    }

    override fun getResult(): Spacecraft = spacecraft
}

class AirplaneBuilder: Builder {
    private val airplane: Airplane = Airplane()

    override fun setName(name: String): AirplaneBuilder {
        airplane.name = name
        return this
    }

    override fun setManufacturer(manufacturer: String): AirplaneBuilder {
        airplane.manufacturer = manufacturer
        return this
    }

    override fun setEngineName(engineName: String): AirplaneBuilder {
        airplane.engineName = engineName
        return this
    }

    override fun setSeats(seats: Int): AirplaneBuilder {
        airplane.seats = seats
        return this
    }

    override fun setPayloadCapacity(capacity: String): AirplaneBuilder {
        airplane.payloadCapacity = capacity
        return this
    }

    override fun getResult(): Airplane = airplane
}

class BuilderDirector {
    var builder: Builder? = null

    private fun checkBuilder() {
        if (builder == null)
            throw RuntimeException("The builder was not specified")
    }

    fun createSpaceShuttleAtlantis(): Spacecraft {
        checkBuilder()
        return builder!!
                .setName("Atlantis")
                .setManufacturer("NASA")
                .setEngineName("Rocketdyne")
                .setSeats(7)
                .getResult() as Spacecraft
    }

    fun createDragonSpaceship(): Spacecraft {
        checkBuilder()
        return builder!!
            .setName("Crew Dragon")
            .setManufacturer("SpaceX")
            .setEngineName("Falcon 9")
            .setSeats(7)
            .getResult() as Spacecraft
    }

    fun create787DreamlinerAirplane(): Airplane {
        checkBuilder()
        return builder!!
            .setName("787-9 Dreamliner")
            .setManufacturer("Boeing")
            .setEngineName("GE GEnx")
            .setSeats(290)
            .getResult() as Airplane
    }
}

class KotlinDirector {
    fun createSpaceShuttleAtlantis(): Spacecraft =
        Spacecraft(
            name = "Atlantis",
            manufacturer = "NASA",
            engineName = "Rocketdyne",
            seats = 7
        )

    fun createCargoDragonSpaceship(): Spacecraft =
        Spacecraft(
            name = "Cargo Dragon",
            manufacturer = "SpaceX",
            engineName = "Falcon 9",
            payloadCapacity = "4201 kg"
        )

    fun create787DreamlinerAirplane(): Airplane =
        Airplane(
            name = "787-9 Dreamliner",
            manufacturer = "Boeing",
            engineName = "GE GEnx",
            seats = 290
        )
}