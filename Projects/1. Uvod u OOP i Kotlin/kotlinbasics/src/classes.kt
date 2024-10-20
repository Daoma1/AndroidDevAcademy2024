fun runExample12() {
    val drogon = Dragon(100, "Drogon")
    println(drogon.name)
}

fun runExample13() {
    val longclaw = Sword("Longclaw", 1)
    val dawn = Sword(name = "Dawn", damage = 3, durability = 300)
    println(longclaw)
    println(longclaw.attack(hits = 12))
    println(longclaw)
    longclaw.repair()
    println(longclaw)
}

class Sword(
    val name: String,
    val damage: Int = 1,
    val durability: Int = 100
) {
    var hitsRemaining: Int = durability
        private set

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