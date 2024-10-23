class Sword(
    val name: String,
    val damage: Int = 1,
    val durability: Int = 100
) {
    var hitsRemaining: Int = durability
        private set(value) {
            field = value
        }

    fun attack(hits: Int): Int {
        val hitsToDo = Math.min(hits, hitsRemaining)
        hitsRemaining -= hitsToDo
        return hitsToDo * damage
    }

    fun repair() {
        hitsRemaining = durability
    }

    override fun toString(): String {
        return "Sword $name, attack damage: $damage, duration: $hitsRemaining."
    }
}

fun pickSword(selection: Int): Sword? {
    return when(selection){
        1 -> Sword("Dawn", 10, 100)
        2 -> Sword("Longclaw", 5, 100)
        2 -> Sword("Needle", 3, 140)
        else -> null
    }
}

fun findSword(): Sword = Sword("Valyrian steel", 20, 1000)