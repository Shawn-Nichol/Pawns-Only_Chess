fun main() {
    val list = mutableListOf(
        MutableList(5) { "_" },
        MutableList(5) { "_" },
        MutableList(5) { "_" },
        MutableList(5) { "_" },
        MutableList(5) { "_" },
    )
    val xList = mutableListOf<Int>()
    val yList = mutableListOf<Int>()

    repeat(3) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        list[x - 1][y - 1] = "x"
    }

    for (i in list.indices) {
        var hasRow = false
        var hasColumn = false

        Row@ for (j in list.indices) {
            if (list[i][j] == "x") {
                hasRow = true
                continue
            }
        }

        if (!hasRow) xList.add(i + 1)

        Column@ for (j in list.indices) {
            if (list[j][i] == "x") {
                hasColumn = true
                continue
            }
        }

        if (!hasColumn) yList.add(i + 1)
    }

    println(xList.joinToString(" "))
    println(yList.joinToString(" "))
}