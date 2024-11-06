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

