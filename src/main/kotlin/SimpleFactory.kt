import model.Earth
import model.Mars
import model.Planet
import model.PlanetNameEnum

class SimpleFactory {
    companion object {
        fun getPlanetInstance(name: PlanetNameEnum): Planet =
            when(name) {
                PlanetNameEnum.EARTH -> Earth()
                PlanetNameEnum.MARS -> Mars()
                else -> throw IllegalArgumentException("Sorry, I don't know this planet yet")
            }
    }
}