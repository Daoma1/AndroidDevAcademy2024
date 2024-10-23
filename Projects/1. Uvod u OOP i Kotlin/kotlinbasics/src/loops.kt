fun runExample6() {
    repeat(3) {
        println("I will not waste loops.")
    }
}

fun runExample7() {
    for (i in (1..5)) {
        println("$i is ${if (i % 2 == 0) "even" else "odd"}")
    }
    for (i in (10 downTo 0 step 2)) {
        println("$i is ${if (i % 2 == 0) "even" else "odd"}")
    }
}

fun runExample8() {
    var dragonsHatched = 0
    println("How many dragons do you need to conquer Westeros?")
    var dragonsNeeded = readln().toInt()
    while (dragonsHatched < dragonsNeeded) {
        println("Hatching dragon ${dragonsHatched+1}")
        dragonsHatched++
    }
    println("Total dragons hatched = $dragonsHatched/$dragonsNeeded")
}

fun runExample9() {
    var dragonsHatched = 0
    println("How many dragons do you need to conquer Westeros?")
    var dragonsNeeded = readln().toInt()
    do {
        println("Hatching dragon ${dragonsHatched+1}")
        dragonsHatched++
    } while (dragonsHatched < dragonsNeeded)
    println("Total dragons hatched = $dragonsHatched/$dragonsNeeded")
}

