package homework.flowcontrol

fun runHomework03() {
    println("Please, enter three integers.")
    print("Enter the first number: ")
    val firstEntry = readln().toInt()
    print("Enter the second number: ")
    val secondEntry = readln().toInt()
    print("Enter the third number: ")
    val thirdEntry = readln().toInt()

    var largestNumber = if (firstEntry > secondEntry) firstEntry else secondEntry
    largestNumber = if (largestNumber > thirdEntry) largestNumber else thirdEntry
    println("The largest one of these is $largestNumber.")
}

fun runHomework04() {
    print("Please, enter a character: ")
    val charEntry = readln().first()
    val isVowel = when (charEntry) {
        'a', 'e', 'i', 'o', 'u' -> true
        else -> false
    }
    println("The character you entered ($charEntry) ${if(isVowel) "is" else "isn't"} a vowel.")
}