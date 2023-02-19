import kotlin.test.Test
import kotlin.test.assertTrue

class Cuid2Test {

    @Test
    fun testGenerateCUID() {
        assertTrue { generateCUID().length == 24 }
        for(i in 1 until 50) {
            assertTrue { generateCUID(i).length == i }
        }
    }

}