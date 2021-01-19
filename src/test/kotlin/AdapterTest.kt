import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.AfterEach


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdapterTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setup() {
        outputStreamCaptor.reset()
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `send a satellite to space through CargoSpacecraft`() {
        val cargoSpacecraft = CargoSpacecraft()
        cargoSpacecraft.sendToSpace("satellite")
        assertEqualsToStream("Sending a satellite to space", "Sending a satellite")
    }

    @Test
    fun `send unknown payload type to space through CargoSpacecraft`() {
        val cargoSpacecraft = CargoSpacecraft()
        cargoSpacecraft.sendToSpace("garbage")
        assertEqualsToStream("Sorry. I cannot send garbage to space.", "Sending garbage")
    }

    @Test
    fun `send humans to space through CargoSpacecraft`() {
        val cargoSpacecraft = CargoSpacecraft()
        cargoSpacecraft.sendToSpace("humans")
        assertEqualsToStream("Sending humans to ISS", "Sending humans")
    }

    @Test
    fun `send a rover to space through CargoSpacecraft`() {
        val cargoSpacecraft = CargoSpacecraft()
        cargoSpacecraft.sendToSpace("rover")
        assertEqualsToStream("Sending a rover to Mars", "Sending a rover")
    }

    private fun assertEqualsToStream(expected: String, message: String) =
        Assertions.assertEquals(expected, outputStreamCaptor.toString().trim(), message)
}