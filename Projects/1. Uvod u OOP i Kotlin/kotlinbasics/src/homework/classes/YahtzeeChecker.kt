package homework.classes

object YahtzeeChecker {
    private const val YAHTZEE_COUNT = 5
    private const val POKER_COUNT = 4

    // Could the result of a check be an object of its own?
    fun isYahtzee(hand: Hand): Boolean {
        val counts = getCounts(hand)
        // A lot of things could be simplified after Lukas lecture
        // val isYahtzee = counts.any { it == YahtzeeCount }
        for (count in counts) {
            if (count >= YAHTZEE_COUNT) {
                return true
            }
        }
        return false
    }

    fun isPoker(hand: Hand): Boolean = getCounts(hand).any { it > POKER_COUNT }

    fun isFullHouse(hand: Hand): Boolean {
        val counts = getCounts(hand)

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

    private fun getCounts(hand: Hand): List<Int> {
        // It could make sense to use a different collection type here. Which one?
        val counts = mutableListOf(0, 0, 0, 0, 0, 0)
        for (i in 0 until hand.handSize) {
            counts[hand.getDieFaceFor(i) - 1]++
        }
        return counts
    }
}