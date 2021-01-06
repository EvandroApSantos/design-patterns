import model.Earth
import model.Mars
import model.Planet

abstract class AbstractPlanetFactory {

    abstract fun createPlanet(): Planet

    fun displayInfo() {
        val planet = createPlanet()
        println(planet.greetings())
        println("My diameter is ${planet.diameter}km")
    }
}

class PlanetEarthFactory: AbstractPlanetFactory() {
    override fun createPlanet(): Planet {
        return Earth()
    }
}

class PlanetMarsFactory: AbstractPlanetFactory() {
    override fun createPlanet(): Planet {
        return Mars()
    }
}

fun main() {
    println("Which planet do you want hear about?")
    val factory = when (readLine()?.toLowerCase()) {
        "earth" -> PlanetEarthFactory()
        "mars" -> PlanetMarsFactory()
        else -> throw IllegalArgumentException("Sorry. I don't know this planet yet :-(")
    }
    factory.displayInfo()
}