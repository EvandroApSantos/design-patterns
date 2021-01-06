package model

interface Planet {
    val diameter: Double
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
    override val diameter = 12.742

    override fun getName(): PlanetNameEnum = PlanetNameEnum.EARTH

    override fun greetings(): String =
        "Greeting from Earth! The most amazing planet in whole universe!"
}

class Mars: Planet {
    override val diameter = 6.779

    override fun getName(): PlanetNameEnum = PlanetNameEnum.MARS

    override fun greetings(): String =
        "Greeting from Mars! I hope humans visit me soon!"
}