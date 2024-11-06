package examples.flowcontrol

import java.util.*

fun runExample03() {
    var winterfellPopulation = 1349
    println("Welcome to Winterfell! Population: $winterfellPopulation")
    println("How many white walkers can you see?")
    val whiteWalkersVisible = readln().toInt()
    if(whiteWalkersVisible > winterfellPopulation)
        println("Winterfell is no more.")
    else
        println("For the king in the north!")
}

fun runExample04() {
    println("Being a businessman. Guide by Littlefinger.")
    println("How to organize a wedding. Step 1 - Get money.")
    val lannisterOffer = 100233
    val tyrellOffer = 123445
    val littleFingerPurseTotal = if(lannisterOffer > tyrellOffer) lannisterOffer else tyrellOffer
    println("Offers are Lannister: $lannisterOffer and Tyrell: $tyrellOffer. Taken $littleFingerPurseTotal.")
}

fun runExample05() {
    println("What is your name?")
    val name = readln()
    println("From which region do you come?")
    val region = readln().lowercase(Locale.getDefault())
    val surname = when (region) {
        "north" -> "Snow"
        "vale" -> "Stone"
        "dorne" -> "Sand"
        "riverlands" -> "Rivers"
        else -> "Commonfolk"
    }
    println("$name $surname")
}