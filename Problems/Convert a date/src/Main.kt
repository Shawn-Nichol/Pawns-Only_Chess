fun main() {
    val input = readLine()!!.toString()
    val (yyyy, mm, dd) = input.split("-")

    println("$mm/$dd/$yyyy")
}