class Army private constructor(val soldiers: Int) {
    companion object {
        const val PRICE_PER_SOLDIER = 3

        fun hire(money: Int): Army {
            return Army(money / PRICE_PER_SOLDIER)
        }
        fun draft(population: Int): Army {
            return Army(population / 2)
        }
    }
}