fun main() {
    val n = readLine()!!.toInt()
    val list = MutableList(n) { readLine()!!.toInt() }
    val m = readLine()!!.toInt()

    println(if (list.contains(m)) "YES" else "NO")

    list.indices
}