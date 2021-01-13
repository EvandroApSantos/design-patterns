import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BuilderTest {

    @Test
    fun `create space shuttle`() {
        val builder = SpacecraftBuilder()
        val director = BuilderDirector()
        director.builder = builder
        val spacecraft = director.createSpaceShuttleAtlantis()
        Assertions.assertEquals(spacecraft.name, "Atlantis", "Spacecraft's name is Atlantis")
        Assertions.assertNull(spacecraft.payloadCapacity, "Spacecraft's payload capacity was not defined")
    }

    @Test
    fun `create spacecraft and airplane`() {
        val director = BuilderDirector()

        val spacecraftBuilder = SpacecraftBuilder()
        director.builder = spacecraftBuilder
        val spacecraft = director.createDragonSpaceship()

        val airplaneBuilder = AirplaneBuilder()
        director.builder = airplaneBuilder
        val airplane = director.create787DreamlinerAirplane()

        Assertions.assertEquals(spacecraft.name, "Crew Dragon", "Spacecraft's name is Crew Dragon")
        Assertions.assertNull(spacecraft.payloadCapacity, "Spacecraft's payload capacity was not defined")
        Assertions.assertEquals(airplane.name, "787-9 Dreamliner", "Airplane's name is 787-9 Dreamliner")
        Assertions.assertNull(airplane.payloadCapacity, "Airplane's payload capacity was not defined")
    }

    @Test
    fun `create space shuttle - KotlinDirector`() {
        val director = KotlinDirector()
        val spacecraft = director.createSpaceShuttleAtlantis()
        Assertions.assertEquals(spacecraft.name, "Atlantis", "Spacecraft's name is Atlantis")
        Assertions.assertNull(spacecraft.payloadCapacity, "Spacecraft's payload capacity was not defined")
    }

    @Test
    fun `create spacecraft and airplane - KotlinDirector`() {
        val director = KotlinDirector()
        val spacecraft = director.createCargoDragonSpaceship()
        val airplane = director.create787DreamlinerAirplane()

        Assertions.assertEquals(spacecraft.name, "Cargo Dragon", "Spacecraft's name is Cargo Dragon")
        Assertions.assertNull(spacecraft.seats, "Spacecraft's seats was not defined")
        Assertions.assertEquals(spacecraft.payloadCapacity, "4201 kg", "Spacecraft's payload capacity was defined")
        Assertions.assertEquals(airplane.name, "787-9 Dreamliner", "Spacecraft's name is 787-9 Dreamliner")
        Assertions.assertNull(airplane.payloadCapacity, "Airplane's payload capacity was not defined")
    }
}