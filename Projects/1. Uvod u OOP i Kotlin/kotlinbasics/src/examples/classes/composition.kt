package examples.classes

fun runExample18() {
    val stick = Sword("Stick", 1, 3)
    println("Swords single attack: ${stick.attack(1)}")
    val syrio = Swordsman(10, true, stick)
    println("Swordsman single attack: ${syrio.attack()}")
}

class Swordsman(
    val strength: Int,
    val isBlessed: Boolean,
    val sword: Sword
) {
    private val blessedMultiplier = 2
    fun attack(): Int {
        val baseDamage = sword.attack(1) + strength
        if(isBlessed)
            return blessedMultiplier * baseDamage
        return baseDamage
    }
}

