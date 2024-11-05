package examples.functions

fun runExample10(){
    displayQuote()
    displayGreeting("Bruno")
    println(generateName("Luka"))
    println(generateName("Filip"))
    println(generateName("Terezija"))
    displayGreeting(generateName("Martin"))
}

fun displayQuote() {
    println("When you play the game of thrones, you win or you die.")
}

fun displayGreeting(name: String) {
    println("Welcome to the wedding, lord $name.")
}

fun generateName(name: String): String {
    if(name.length < 5) return "$name Darkeagle"
    if(name.length < 8) return "$name Ironheart"
    return "$name Sunseeker"
}