package model

interface Planet {
    fun getName(): PlanetNameEnum
    fun greetings(): String
}

enum class PlanetNameEnum {
    MERCURY,
    VENUS,
    EARTH,
    MARS,
    SATURN,
    JUPITER,
    NEPTUNE,
    URANUS
}

class Earth: Planet {
    override fun getName(): PlanetNameEnum = PlanetNameEnum.EARTH

    override fun greetings(): String =
        "Greeting from Earth! The most amazing planet in whole universe!"
}

class Mars: Planet {
    override fun getName(): PlanetNameEnum = PlanetNameEnum.MARS

    override fun greetings(): String =
        "Greeting from Mars! I hope humans visit me soon!"
}