package homework.classes

import kotlin.math.PI

class Circle(val radius: Double = 1.0) {
    fun calculateArea(): Double {
        return radius * radius * PI
    }

    fun calculateCircumference(): Double {
        return 2 * radius * PI
    }
}