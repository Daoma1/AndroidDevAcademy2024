package homework.classes

import homework.classes.cards.Deck
import homework.classes.geometry.Circle
import homework.classes.geometry.Point
import homework.classes.yahtzee.*
import kotlin.random.Random

fun runHomework12() {
    val unitCircle = Circle()
    println("Area of the unit circle is ${unitCircle.calculateArea()}")
    println("Circumference of the unit circle is ${unitCircle.calculateCircumference()}")

    val largeCircle = Circle(12.0)
    println("Area of the large circle is ${largeCircle.calculateArea()}")
    println("Circumference of the large circle is ${largeCircle.calculateCircumference()}")
}

fun runHomework13() {
    val a = Point()
    val b = Point(2, 3)
    println("Point a: (${a.x}, ${a.y})")
    println("Point b: (${b.x}, ${b.y})")
    println("Translating a by -3, 2")
    a.translate(-3, 2)
    println("Translated point a: (${a.x}, ${a.y})")
    val distance = a.calculateEuclideanDistanceTo(b)
    println("Euclidean distance from a to b is $distance")
}

fun runHomework14() {
    val generator: Random = Random.Default

    // Die test:
    val die = Die(generator)
    println(die.face)
    println(die.sides)
    die.roll()
    println(die.face)
    die.roll()
    println(die.face)

    // Hand test:
    val hand = Hand(generator)
    println(hand.getAsString())
    hand.roll()
    println(hand.getAsString())
    hand.lock(1)
    hand.lock(2)
    println(hand.getAsString())
    hand.roll()
    println(hand.getAsString())

    // Yahtzee checker test
    println("Rolling for Yahtzee")
    val luckyHand = Hand(generator)
    println(luckyHand.getAsString())
    var counter = 0
    do {
        luckyHand.roll()
        counter++
    } while (!YahtzeeEvaluator.isYahtzee(luckyHand))
    println("It took $counter attempts to get a Yahtzee")
    println(luckyHand.getAsString())
    println("Is it also a poker? ${PokerEvaluator.isPoker(luckyHand)}")
    println("Is it also a full house? ${FullHouseEvaluator.isFullHouse(luckyHand)}")

    println("Rolling for full house.")
    counter = 0
    do {
        luckyHand.roll()
        counter++
    } while (!FullHouseEvaluator.isFullHouse(luckyHand))
    println("It took $counter attempts to get a full house")
    println(luckyHand.getAsString())
}

fun runHomework15() {
    // Consider creating a game class.
    // What would be its state?
    // What behaviour would you like/expect?
    var playerOnePoints = 0
    var playerTwoPoints = 0
    val deck = Deck()
    deck.shuffle()

    while (deck.cardsLeft > 0) {
        val playerOneCard = deck.deal()
        val playerTwoCard = deck.deal()
        print("One drew: ${playerOneCard.getAsString()}, Two drew ${playerTwoCard.getAsString()}. ")
        if (playerOneCard.isStrongerThan(playerTwoCard)) {
            println("One wins the round!")
            playerOnePoints++
        } else if (playerTwoCard.isStrongerThan(playerOneCard)) {
            println("Two wins the round!")
            playerTwoPoints++
        } else {
            println("It's a draw!")
        }
    }
    println("==============================")
    println("Game over!")
    println("==============================")
    println("Player one score: $playerOnePoints")
    println("Player two score: $playerTwoPoints")
}