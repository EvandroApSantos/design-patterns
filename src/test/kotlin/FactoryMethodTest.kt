import model.Earth
import model.Mars
import model.PlanetNameEnum
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FactoryMethodTest {

    @Test
    fun `planet Earth factory`() {
        val planet = PlanetEarthFactory().createPlanet()
        assert(planet is Earth)
        Assertions.assertEquals(planet.getName(), PlanetNameEnum.EARTH)
        Assertions.assertEquals(planet.greetings(), "Greeting from Earth! The most amazing planet in whole universe!")
    }

    @Test
    fun `create planet Mars`() {
        val planet = PlanetMarsFactory().createPlanet()
        assert(planet is Mars)
        Assertions.assertEquals(planet.getName(), PlanetNameEnum.MARS)
        Assertions.assertEquals(planet.greetings(), "Greeting from Mars! I hope humans visit me soon!")
    }
}