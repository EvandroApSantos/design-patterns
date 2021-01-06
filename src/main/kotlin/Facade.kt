import model.Planet
import model.PlanetNameEnum
import kotlin.math.abs

class SpaceshipTravelFacade {
    fun travel(origin: String, destination: String) {
        val originPlanet = SimpleFactory.getPlanetInstance(PlanetNameEnum.valueOf(origin))
        val destinationPlanet = SimpleFactory.getPlanetInstance(PlanetNameEnum.valueOf(destination))

        val spaceship = Spaceship(originPlanet, destinationPlanet)
        spaceship.calculateDistance()
        spaceship.calculateTimeOfTravel()
        spaceship.displayTravelInfo()
        val groundControl = GroundControl()
        groundControl.handleSpaceship(spaceship)
        spaceship.liftoff()
    }
}

class Spaceship(
    val origin: Planet,
    val destination: Planet
) {
    private var distance: Long = 0
    private var timeOfTravel: Long = 0

    fun calculateDistance() {
        checkOriginAndDestination()
        distance = abs(origin.distanceFromSun - destination.distanceFromSun)
    }

    fun calculateTimeOfTravel() {
        checkOriginAndDestination()
        timeOfTravel = distance / 30_000 / 24 / 12
    }

    fun displayTravelInfo() {
        println("This spaceship is traveling from ${origin.getName()} to ${destination.getName()}")
        println("The distance is ${distance}km and the we will take about $timeOfTravel months to arrive")
    }

    fun liftoff() {
        println("Lifting off! Goodbye ${origin.getName()}!")
    }

    fun setName(name: String) {
        println("Nice! The spaceship was named as $name")
    }

    private fun checkOriginAndDestination() {
        if (origin.getName() == destination.getName())
            throw IllegalArgumentException("It is not possible to start the trip from the same origin")
    }
}

class GroundControl {
    fun handleSpaceship(spaceship: Spaceship) {
        println("This is ground control.")
        println("I'll be with you from ${spaceship.origin.getName()} to ${spaceship.destination.getName()}")
    }
}

fun main() {
    SpaceshipTravelFacade().travel("EARTH", "MARS")
    println("\n")
    SpaceshipTravelFacade().travel("MARS", "EARTH")
    println("\n")
    SpaceshipTravelFacade().travel("MARS", "MARS")
}