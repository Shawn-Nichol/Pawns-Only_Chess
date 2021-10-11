fun main() {
    val n = readLine()!!.first()

    for (i in 'a'..'z') {
        if (i == n) break
        print(i)
    }
}