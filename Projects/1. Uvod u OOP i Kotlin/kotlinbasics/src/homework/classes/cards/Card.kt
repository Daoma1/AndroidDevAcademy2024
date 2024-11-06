package homework.classes.cards

class Card(private val suit: Suit, private val face: Face) {

    fun isStrongerThan(other: Card) = this.face > other.face

    fun getAsString(): String = "$face of $suit" // Haven't learned override yet.
}