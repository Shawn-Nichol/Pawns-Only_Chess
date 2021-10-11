fun main() {
    val numbers = readLine()!!.split(' ').map{ it.toInt() }.toMutableList()
    // do not touch the lines above
    // write your code here   
    val sum = numbers.sum()
    numbers.remove(numbers[numbers.size - 2])
    numbers.add(0, sum)

    // do not touch the lines below
    println(numbers.joinToString(" "))
}