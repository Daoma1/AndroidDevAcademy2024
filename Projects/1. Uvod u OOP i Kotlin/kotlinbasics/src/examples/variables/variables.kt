package examples.variables

fun runExample1() {
    val name = "Jon Snow"
    var amountOfKnowledge = 0
    println("Before Android academy.")
    println("$name knows: $amountOfKnowledge.")
    amountOfKnowledge = 1
    println("After Android academy.")
    println("$name knows: $amountOfKnowledge.")
}

fun runExample2() {
    var spies: Int
    val direwolves: Int
    spies = 10
    direwolves = 6
    // Each direwolves eats a spy
    println("There are $spies spies and $direwolves direwolves.")
    spies = spies - direwolves
    // direwolves = direwolves - 1 // Whoops! Can't kill a direwolf in kotlin.
    println("There are $spies spies and $direwolves direwolves.")
}