package homework.loops

import kotlin.math.abs

fun runHomework05() {
    println("Please, enter a positive number: ")
    val n = readln().toInt()
    var sum = 0.0
    for (i in 1..n) {
        sum += i
    }
    println("The sum of all numbers from 1 until $n is: $sum")
    println("Kotlin likes it short, you can use sum() on a range: ${(1..n).sum()}.")
}

fun runHomework06() {
    println("Please, enter the lower bound: ")
    var lowerBound = readln().toInt()
    println("Please, enter the upper bound: ")
    var upperBound = readln().toInt()
    if (upperBound < lowerBound) {
        val temp = upperBound
        upperBound = lowerBound
        lowerBound = temp
    }

    var number: Int
    do {
        println("Please, enter a number between $lowerBound and $upperBound")
        number = readln().toInt()
    } while (number < lowerBound || number > upperBound)

    number = abs(number)
    var maxDigit = number % 10
    do {
        number /= 10
        val digit = number % 10
        if (digit > maxDigit)
            maxDigit = digit
    } while (number > 0)
    println("The largest digit is $maxDigit")
}