package homework.classes.yahtzee

import kotlin.random.Random

class Hand(generator: Random) {
    val handSize = 6

    // We need to hold several Die objects, we could do it
    // individually, but it makes sense to use a collection.
    // Luka will be talking about this in more detail.
    private val dice = List(handSize) { Die(generator) }
    private val locks = MutableList(handSize) { false }

    fun lock(index: Int) {
        locks[index] = true
    }

    fun unlock(index: Int) {
        locks[index] = false
    }

    fun getAsString(): String {
        val stringBuilder = StringBuilder()
        for (i in 0 until handSize) {
            val lockSymbol = if (locks[i]) "x" else ""
            stringBuilder.append("[")
                .append(dice[i].face)
                .append(lockSymbol)
                .append("]")
        }
        return stringBuilder.toString()
    }

    fun getDieFaceFor(index: Int): Int = dice[index].face

    fun getRolledCounts(): List<Int> {
        // It could (and it does) make sense to use a different collection type here. Which one?
        // Listen to Luka on the next lecture and replace this with a dictionary.
        // Or create your own class for this. Returning a list such as this one makes it harder
        // for everyone to understand the code. Although simple, it makes you think what is going on.
        val counts = mutableListOf(0, 0, 0, 0, 0, 0)
        for (i in 0 until handSize) {
            counts[getDieFaceFor(i) - 1]++
        }
        return counts
    }

    fun roll() {
        for (i in 0 until handSize) {
            if(!locks[i]) {
                dice[i].roll()
            }
        }
        // Try to do it with a for loop and iterating over the indices of the collections.
        // Learn about the zip operator from Luka.
        // Can you maybe make the Die itself lockable?
        // for ((die, lock) in dice.zip(locks)) {
        //     if (!lock) {
        //         die.roll()
        //     }
        // }
    }
}