package homework.strings

fun runHomework09() {
    println("P4ss - ${isStrongPasswordCandidate("P4ss")}")
    println("password - ${isStrongPasswordCandidate("password")}")
    println("Password - ${isStrongPasswordCandidate("Password")}")
    println("p4ssw0rd - ${isStrongPasswordCandidate("p4ssw0rd")}")
    println("P4ssw0rd - ${isStrongPasswordCandidate("P4ssw0rd")}")
}

fun runHomework10() {
    println("Objektno - ${countVowels("Objektno")}")
    println("orijentirano - ${countVowels("orijentirano")}")
    println("programiranje - ${countVowels("programiranje")}")
}

fun runHomework11() {
    println("Objektno - ${countUniqueCharacters("Objektno")}") // O is different from o
    println("orijentirano - ${countUniqueCharacters("orijentirano")}")
    println("programiranje - ${countUniqueCharacters("programiranje")}")
}

fun countUniqueCharacters(word: String): Int {
    // Let's do this without sets or dictionaries
    // It's often easier to break down a problem into
    // steps, where a step is represented by a function
    var uniqueCharacterCount = 0
    for (element in word) {
        if (isUnique(word, element)) {
            uniqueCharacterCount++
        }
    }
    return uniqueCharacterCount

    // Learn about groupings, hashmaps and extension functions from Luka!
    //    return word.groupingBy { it }
    //        .eachCount()
    //        .filter { it.value == 1 }
    //        .count()
}

fun isUnique(text: String, character: Char): Boolean {
    var appearances = 0
    for (item in text) {
        if (character == item)
            appearances++
    }
    return appearances == 1
}

fun countVowels(word: String): Int {
    val vowels = "aeiou"
    val lowercaseWord = word.lowercase()
    var vowelCount = 0
    for (letter in lowercaseWord) {
        if (vowels.contains(letter)) {
            vowelCount++
        }
    }
    return vowelCount
}

fun isStrongPasswordCandidate(candidate: String): Boolean {
    val minLength = 8
    var containsUppercaseLetter = false
    var containsDigit = false

    if (candidate.length < minLength)
        return false

    for (letter in candidate) {
        if (letter.isDigit())
            containsDigit = true
        if (letter.isUpperCase())
            containsUppercaseLetter = true
    }
    return containsDigit && containsUppercaseLetter
}