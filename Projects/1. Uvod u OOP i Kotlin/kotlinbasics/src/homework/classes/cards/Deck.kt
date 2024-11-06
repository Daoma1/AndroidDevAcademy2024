package homework.classes

class Deck {
    private val cards: MutableList<Card> = mutableListOf()

    init {
        for (suit in Suit.entries) {
            for (face in Face.entries) {
                cards.add(Card(suit, face))
            }
        }
    }

    val cardsLeft: Int
        get() = cards.count()

    fun shuffle() = cards.shuffle()

    fun deal(): Card = cards.removeLast()
}