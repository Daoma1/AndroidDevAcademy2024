package homework.classes

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

    fun roll() {
        for ((die, lock) in dice.zip(locks)) {
            if (!lock) {
                die.roll()
            }
        }
    }
}