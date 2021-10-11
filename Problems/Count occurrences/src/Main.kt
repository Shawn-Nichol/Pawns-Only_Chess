fun main() {
    val list = MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }
    val m = readLine()!!.toInt()

    println(list.count() { it == m })
}