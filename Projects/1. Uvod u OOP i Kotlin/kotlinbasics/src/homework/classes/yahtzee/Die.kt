package homework.classes

import kotlin.random.Random

class Die(val generator: Random) {
    val sides = 6
    var face = 1
        private set

    fun roll() {
        face = generator.nextInt(1, sides + 1)
    }
}