fun main() {
    val input = readLine()!!.toString()
    val list = input.split(" ").toMutableList()
    var longest = ""

    for (i in list) {
        if (i.length > longest.length) {
            longest = i
        }
    }

    println(longest)
}