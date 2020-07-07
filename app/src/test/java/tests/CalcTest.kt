package tests

import org.junit.Test

class CalcTest {

    private val calc = Calc()

    @Test
    fun somar() {
        assert(calc.somar(2, 3) == 5)
    }

    @Test
    fun sub() {
        assert(calc.sub(4, 3) == 1)
    }

    @Test
    fun div() {
        assert(calc.div(300.0, 30000.0) == 0.01)
    }

    @Test
    fun mult() {
        assert(calc.mult(2, 3) == 6)
    }

    @Test
    fun acessaListaSucesso() {
        assert(calc.acessaLista() != -1)
    }

    @Test
    fun acessaListaErro() {
        calc.list = listOf()
        assert(calc.acessaLista() == -1)
    }
}