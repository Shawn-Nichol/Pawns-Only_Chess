fun f(x: Double): Double {
    // call your implemented functions here
    var num = 0.0
    if (x <= 0) num = f1(x)
    if (0 < x && x < 1) num += f2(x)
    if (x >= 1) num += f3(x)

    return num
}

// implement your functions here
fun f1(x: Double): Double {
    return x * x + 1.0
}

fun f2(x: Double): Double {
    return 1.0 / (x * x)
}

fun f3(x: Double): Double {
    return x * x - 1
}