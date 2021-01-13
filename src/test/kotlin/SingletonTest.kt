import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SingletonTest {

    @Test
    fun `check same instance`() {
        val earth = PlanetEarthFactory().createPlanet()
        val singleton1 = Singleton.getInstance(earth)
        val mars = PlanetMarsFactory().createPlanet()
        val singleton2 = Singleton.getInstance(mars)
        Assertions.assertEquals(singleton1.planet, earth, "Planet 'earth' expected")
        Assertions.assertEquals(singleton2.planet, earth, "Same previous planet 'earth' expected")
    }

    @Test
    fun `check same instance - KotlinSingleton`() {
        runBlocking {
            val singleton1CreatedAt = KotlinSingleton.createdAt
            delay(3_000)
            val singleton2CreatedAt = KotlinSingleton.createdAt
            Assertions.assertEquals(singleton1CreatedAt, singleton2CreatedAt, "Same creation date and time")
        }
    }
}