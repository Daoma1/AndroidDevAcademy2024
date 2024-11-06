package homework.functions

import kotlin.math.sqrt

fun runHomework07() {
    // Could a function be created to avoid repetition in this function?
    println("3 to the power of 3 = ${findNthPower(3, 3)}")
    println("9 to the power of 2 = ${findNthPower(9, 2)}")
    println("-3 to the power of 2 = ${findNthPower(-3, 2)}")
    println("-3 to the power of 3 = ${findNthPower(-3, 3)}")
    // Overflow:
    println("10 to the power of 19 = ${findNthPower(10, 19)}")
}

fun runHomework08() {
    // Could a function be created to avoid repetition in this function?
    println("2 ${if(isPrime(2)) "is" else "isn't" } a prime number.")
    println("9 ${if(isPrime(9)) "is" else "isn't" } a prime number.")
    println("10 ${if(isPrime(10)) "is" else "isn't" } a prime number.")
    println("11 ${if(isPrime(11)) "is" else "isn't" } a prime number.")
    println("24 ${if(isPrime(24)) "is" else "isn't" } a prime number.")
    println("37 ${if(isPrime(37)) "is" else "isn't" } a prime number.")
}

fun isPrime(number: Int) : Boolean {
    for (i in 2..sqrt(number.toDouble()).toInt()) {
        if(number % i == 0) {
            return false
        }
    }
    return true
}

fun findNthPower(number: Int, power: Int): Long {
    var numberToPower = 1L
    for (i in 1..power) {
        numberToPower *= number
        // A good idea would be to check for an under/overflow.
        // Read more about this on
        // https://rosettacode.org/wiki/Integer_overflow
    }
    return numberToPower
}