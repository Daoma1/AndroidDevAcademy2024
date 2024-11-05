package examples.classes

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

fun runExample14() {
    val danaerys = Character("Danaerys", true, 1, 8)
    val jorah = Character("Jorah", false, 10, 2)
    println(danaerys)
    println(jorah)
}

fun runExample15() {
    println("Total swords in the throne: ${TheIronThrone.swordCount}")
    println("Dragons burn down enemy")
    TheIronThrone.meltSwordOfFallenEnemy()
    println("Total swords in the throne: ${TheIronThrone.swordCount}")
}

fun runExample16() {
    val borrowedGold = 1000
    val unsullied = Army.hire(borrowedGold);
    println("Unsullied: ${unsullied.soldiers}.")
    val winterfellPopulation = 1045
    val nightsWatch = Army.draft(winterfellPopulation);
    println("Nights Watch: ${nightsWatch.soldiers}.")
}



fun runExample17() {
//    // Non-nullable and nullable type:
//    val longclaw: Sword = null  // Illegal
//    val dawn: Sword? = null     // Legal
//
//    // Using methods returning null
//    val nullable_sword: Sword? = pickSword(1)
//    nullable_sword.repair() // Cannot be used on a nullable type reference
//    nullable_sword?.repair() // Safe call operator can be used
//    val non_nullable_sword: Sword = pickSword(2)  // Illegal, can't combine
//
//    // How to combine?
//    val sword = pickSword(2) ?: findSword()
//    sword.repair()
}