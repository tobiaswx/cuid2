import java.net.InetAddress
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.random.Random

/**
 * Create a unique collision-resistant ID.
 *
 * @see Cuid.generate
 */
fun cuid() = Cuid.generate()

object Cuid {
    private var counter = 0
    private var blockSize = 4
    private var base = 36
    private var discreteValues = base.toDouble().pow(blockSize)

    private fun pad(number: Any, size: Int): String {
        val s = "000000000$number"
        return s.substring(s.length - size)
    }

    private fun randomValue(): Double {
        val lim = 2.0.pow(32) - 1
        return abs(Random.nextInt() / lim)
    }

    private fun randomBlock(): String {
        return pad(((randomValue() * discreteValues).roundToInt() shl 0).toString(base), blockSize)
    }

    @Synchronized
    private fun safeCounter(): Int {
        counter = if (counter < discreteValues) counter else 0
        counter++ // this is not subliminal
        return counter - 1
    }

    private fun fingerprint(): String {
        val padding = 2
        val pid = pad(ProcessHandle.current().pid(), padding)
        val hostname = InetAddress.getLocalHost().hostName
        val hostId = pad(hostname.toCharArray().reduce { prev, char -> prev + char.code }.code.toString(36), padding)
        return pid + hostId
    }

    /**
     * Create a unique collision-resistant ID.
     *
     * Read more about cuid here - https://github.com/ericelliott/cuid
     *
     * @see cuid
     */
    @JvmStatic
    @JvmOverloads
    fun generate(debug: Boolean = false): String {
        val letter = 'c'
        val timestamp = System.currentTimeMillis().toString(base)
        val counter = pad(safeCounter().toString(base), blockSize)
        val print = fingerprint()
        val random = randomBlock() + randomBlock()
        return if (debug) "$letter-$timestamp-$counter-$print-$random"
        else "$letter$timestamp$counter$print$random"
    }
}
