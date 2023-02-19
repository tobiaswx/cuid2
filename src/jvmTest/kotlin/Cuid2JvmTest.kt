import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.random.Random
import kotlin.random.nextInt

class Cuid2JvmTest {

    @Test
    fun testGenerateCUIDException() {
        assertThrows<IllegalArgumentException> {
            generateCUID(0)
        }
        for(i in 1 until 50) {
            assertDoesNotThrow { generateCUID(i) }
        }
        assertThrows<IllegalArgumentException> {
            generateCUID(51)
        }
        assertThrows<IllegalArgumentException> {
            generateCUID(
                Random.nextInt(range = 51 .. Int.MAX_VALUE ))
        }
    }

}