package homework.classes.yahtzee

object YahtzeeEvaluator {

    private const val YAHTZEE_COUNT = 5

    fun isYahtzee(hand: Hand): Boolean {
        val counts = hand.getRolledCounts()
        // A lot of things could be simplified after Lukas lecture
        // val isYahtzee = counts.any { it == YahtzeeCount }
        for (count in counts) {
            if (count >= YAHTZEE_COUNT) {
                return true
            }
        }
        return false
    }
}

object PokerEvaluator {

    private const val POKER_COUNT = 4

    fun isPoker(hand: Hand): Boolean = hand.getRolledCounts().any { it >= POKER_COUNT }
}

object FullHouseEvaluator {

    fun isFullHouse(hand: Hand): Boolean {
        val counts = hand.getRolledCounts()
        var hasThreeOfKind = false
        var threeOfKindIndex = -1
        for (i in 0 until counts.size) {
            if (counts[i] >= 3) {
                hasThreeOfKind = true
                threeOfKindIndex = i
            }
        }
        if (!hasThreeOfKind)
            return false

        for (i in 0 until counts.size) {
            if (i != threeOfKindIndex && counts[i] >= 2) {
                return true
            }
        }
        return false
    }
}