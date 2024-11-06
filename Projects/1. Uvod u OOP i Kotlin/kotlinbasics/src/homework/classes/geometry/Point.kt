package homework.classes.geometry

import kotlin.math.sqrt

class Point(var x: Int = 0, var y: Int = 0) {

    constructor(coordinate: Int) : this(coordinate, coordinate)

    fun translate(shiftX: Int, shiftY: Int) {
        x += shiftX
        y += shiftY
    }

    fun calculateEuclideanDistanceTo(other: Point): Double {
        return sqrt(
            ((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y)).toDouble()
        )
    }
}