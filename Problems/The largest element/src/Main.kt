fun main() {
    var largest = 0
    var n = readLine()!!.toInt()

    while (n != 0) {
        if (n > largest) largest = n
        n = readLine()!!.toInt()
    }

    println(largest)
}