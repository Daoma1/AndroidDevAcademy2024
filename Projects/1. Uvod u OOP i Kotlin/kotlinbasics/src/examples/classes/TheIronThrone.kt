package examples.classes

object TheIronThrone {
    var swordCount = 1000

    fun meltSwordOfFallenEnemy() { swordCount++ }

    fun meltSwordOfFallenEnemy(swordCount: Int) { TheIronThrone.swordCount += swordCount }
}