fun main() {
    val n = readLine()!!.toInt()
    var low: Int = Int.MAX_VALUE

    for (i in 1..n) {
        val num = readLine()!!.toInt()
        if (num < low) {
            low = num
        }
    }
}