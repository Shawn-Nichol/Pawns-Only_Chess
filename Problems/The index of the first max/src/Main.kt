fun main() {
    val size = readLine()!!.toInt()
    val list: MutableList<Int> = MutableList(size) { readLine()!!.toInt() }

    println(list.indexOf(list.maxOrNull()))
}