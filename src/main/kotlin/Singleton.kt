import model.Planet
import java.time.Instant

//Not thread safe and ugly code :-(
class Singleton private constructor(val planet: Planet) {

    companion object {
        private var instance: Singleton? = null

        fun getInstance(planet: Planet): Singleton {
            instance = instance ?: Singleton(planet)
            return instance!!
        }
    }
}

//Simple, clean and thread safe code! \o/
object KotlinSingleton {
    val createdAt = Instant.now()
}