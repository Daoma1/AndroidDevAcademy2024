package homework.classes.yahtzee

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