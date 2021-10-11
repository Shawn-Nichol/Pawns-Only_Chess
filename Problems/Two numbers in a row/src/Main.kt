fun main() {
    val list = MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }
    val (p, m) = readLine()!!.split(" ").map { it.toInt() }
    var state = "YES"

    for (i in 0..list.size - 2) {
        if (list[i] == p && list[i + 1] == m || list[i] == m && list[i + 1] == p) {
            state = "NO"
        }
    }

    println(state)
}