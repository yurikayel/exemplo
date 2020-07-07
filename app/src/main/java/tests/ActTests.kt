package tests

import androidx.appcompat.app.AppCompatActivity

class ActTests : AppCompatActivity() {

    fun somar(x: Int, y: Int) = x + y

    fun sub(x: Int, y: Int) = x - y

    fun div(x: Int, y: Int) = x / y

    fun mult(x: Int, y: Int) = x * y

}

class Calc {

    var list = listOf(0, 1, 2, 3, 4)

    fun somar(x: Int, y: Int) = x + y

    fun sub(x: Int, y: Int) = x - y

    fun div(x: Double, y: Double) = x / y

    fun mult(x: Int, y: Int) = x * y

    fun acessaLista(): Int = try {
        list[3]
    } catch (outOfBounds: IndexOutOfBoundsException) {
        -1
    }

}