
private external fun require(module: String): dynamic

private val cuid2 = require("@paralleldrive/cuid2")

actual fun generateCUID(length: Int?): String {
    return when {
        length != null -> cuid2.init(js("{ length: length }"))()
        else -> cuid2.createId()
    }.toString()
}
