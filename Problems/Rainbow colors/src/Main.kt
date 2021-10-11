enum class Rainbow() {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    INDIGO,
    VIOLET;

    companion object {
        fun isRainbow(color: String): Boolean {
            return values().any() { it.name == color.toUpperCase() }
        }
    }
}

fun main() {

    val rain = Rainbow
    println(rain.isRainbow(readLine()!!))
}