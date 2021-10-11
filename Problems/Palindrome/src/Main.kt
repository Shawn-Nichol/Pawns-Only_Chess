fun main() {
    val input = readLine()!!.toString()
    val r = input.reversed()
    println(if (input == r) "yes" else "no")
}