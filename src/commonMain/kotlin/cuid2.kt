/**
 * Creates a CUID version 2 with the specified length (limitation: 1 to 50 on the JVM) or the default length of the respective platform library.
 */
expect fun generateCUID(length: Int? = null): String
