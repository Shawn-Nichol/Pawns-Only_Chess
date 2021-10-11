fun main() {
    val size = readLine()!!.toInt()
    val list = MutableList(size) { readLine()!!.toInt() }
    val (p, m) = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    println(if (list.contains(p) && list.contains(m)) "YES" else "NO")
}