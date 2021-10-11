import kotlin.math.sqrt

val list = mutableListOf<Double>()

fun main() {
    var area = 0.0
    when (readLine()!!.toString()) {
        "rectangle" -> {
            numbers(2)
            area = list[0] * list[1]
        }
        "triangle" -> {
            numbers(3)
            val s = 0.5 * (list[0] + list[1] + list[2])
            area = sqrt(s * (s - list[0]) * (s - list[1]) * (s - list[2]))
        }
        "circle" -> {
            numbers(1)
            area = 3.14 * (list[0] * list[0])
        }
    }

    println(area)
}

fun numbers(size: Int) {
    repeat(size) {
        list.add(readLine()!!.toDouble())
    }
}