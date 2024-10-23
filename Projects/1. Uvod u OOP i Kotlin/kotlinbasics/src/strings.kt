fun runExample11(){
    println(calculatePoints("Dracarys"))
    println(calculatePoints("The night watch"))
}

fun calculatePoints(word: String): Int {
    val pointsPerVowel = 2
    val pointsPerSegment = 3
    val segmentLength = 3

    val segmentPoints = (word.length / segmentLength) * pointsPerSegment
    var vowelPoints = 0
    val vowels = setOf('a','e','i','o','u')
    for (letter in word) {
        if(letter in vowels) {
            vowelPoints += pointsPerVowel
        }
    }
    return vowelPoints + segmentPoints
}