fun main() {
    val n = readLine()!!.toInt()

    println(when (n) {
        1, 3, 4 -> "No!"
        2 -> "Yes!"
        else -> "Unknown number"
    })
}