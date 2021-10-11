fun main() {
    var total = 0
    val n = readLine()!!.toString()

    for (i in n.indices) {
        var matching = false
        for (j in n.indices) {
            if (i == j) continue
            if (n[i] == n[j]) {
                matching = true
                break
            }
        }
        if (!matching) total++
    }

    println(total)
}