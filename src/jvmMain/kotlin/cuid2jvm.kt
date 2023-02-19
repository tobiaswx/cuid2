import io.github.thibaultmeyer.cuid.CUID

actual fun generateCUID(length: Int?): String {
    return when {
        length != null -> when(length) {
            !in 1 until 50 -> throw IllegalArgumentException("Length must be between 1 and 50")
            else -> CUID.randomCUID2(length)
        }
        else -> CUID.randomCUID2()
    }.toString()
}
