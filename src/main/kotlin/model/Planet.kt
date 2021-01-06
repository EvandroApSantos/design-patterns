package model

interface Planet {
    val diameter: Int
    val distanceFromSun: Long
    fun getName(): PlanetNameEnum
    fun greetings(): String
}

enum class PlanetNameEnum {
    MERCURY,
    VENUS,
    EARTH,
    MARS,
    JUPITER,
    SATURN,
    NEPTUNE,
    URANUS
}

class Earth: Planet {
    override val diameter = 12742
    override val distanceFromSun = 147_100_000L

    override fun getName(): PlanetNameEnum = PlanetNameEnum.EARTH

    override fun greetings(): String =
        "Greeting from Earth! The most amazing planet in whole universe!"
}

class Mars: Planet {
    override val diameter = 6779
    override val distanceFromSun = 228_230_000L

    override fun getName(): PlanetNameEnum = PlanetNameEnum.MARS

    override fun greetings(): String =
        "Greeting from Mars! I hope humans visit me soon!"
}