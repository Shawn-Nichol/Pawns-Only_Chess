fun main() {
    val size = readLine()!!.toInt()
    val a = MutableList(size) { readLine()!!.toInt() }
    val b = mutableListOf(a.last())

    for (i in 0..a.size - 2) {
        b.add(i + 1, a[i])
    }

    println(b.joinToString(" "))
}