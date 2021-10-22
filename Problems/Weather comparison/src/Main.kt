class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = if (value !in -97..57) {
                when (name) {
                    "Moscow" -> 5
                    "Hanoi" -> 20
                    "Dubai" -> 30
                    else -> 0
                }
            } else value
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()

    val firstCity = City("Dubai")
    firstCity.degrees = first

    val secondCity = City("Moscow")
    secondCity.degrees = second

    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    // implement comparing here
    val cityList = listOf(firstCity, secondCity, thirdCity).sortedBy { it.degrees }
    println(if (cityList[0].degrees == cityList[1].degrees) "neither" else cityList[0].name)

}