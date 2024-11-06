package homework.classes.yahtzee

object PokerEvaluator {

    private const val POKER_COUNT = 4

    fun isPoker(hand: Hand): Boolean = hand.getRolledCounts().any { it >= POKER_COUNT }
}