fun main() {
    var count = 0
    val size = readLine()!!.toInt()
    val mList: MutableList<Int> = MutableList(size) { readLine()!!.toInt() }

    for (i in 0 until mList.size - 2) {
        if (mList[i] + 1 == mList[i + 1] && mList[i] + 2 == mList[i + 2]) {
            count++
        }
    }

    println(count)
}