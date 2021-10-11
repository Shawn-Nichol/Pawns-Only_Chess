fun main() {
    val a = MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }
    val rot = readLine()!!.toInt()
    val b = MutableList(a.size) { 0 }

    for (i in a.indices) {
        b[(rot + i) % a.size] = a[i]
    }

    println(b.joinToString(" "))
}