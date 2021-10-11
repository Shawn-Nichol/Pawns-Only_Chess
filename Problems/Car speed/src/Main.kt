fun main(args: Array<String>) {

    val regex = Regex("[0-9]?[0-9][0-9]")
    val i1 = readLine()!!.toInt()
    val i2 = readLine()!!.run { if (this.matches(regex)) this.toInt() else 60 }

    println(speed(i1, i2))
}

fun speed(currentSpeed: Int, speedLimit: Int = 60): String {
    return if (speedLimit < currentSpeed) {
        "Exceeds the limit by ${currentSpeed - speedLimit} kilometers per hour"
    } else {
        "Within the limit"
    }
}