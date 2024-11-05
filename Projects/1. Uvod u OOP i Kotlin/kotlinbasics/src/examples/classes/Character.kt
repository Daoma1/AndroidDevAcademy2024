package examples.classes

class Character(
    val name: String,
    val isValyrian: Boolean = false,
    var strength: Int,
    var intelligence: Int,
) {
    constructor() : this("Unknown", false, 1, 1) {}
    constructor(name: String) : this(name, false, 1, 1) {}

    val dexterity: Int = intelligence * 2 - strength // Initializer

    // Init block:
    init {
        if (isValyrian) {
            this.strength *= 2
            this.intelligence *= 2
        }
    }

    // Expression bodied method:
    override fun toString(): String = "$name ${if (isValyrian) "of Valyria " else ""} S:$strength I:$intelligence "
}