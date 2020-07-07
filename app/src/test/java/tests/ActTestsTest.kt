package tests

import org.junit.Test
import org.mockito.Mockito.mock

class ActTestsTest {

    val mockActivity = mock(ActTests::class.java)

    @Test
    fun somar() {
        mockActivity.somar(2, 3)
    }

    @Test
    fun sub() {
    }

    @Test
    fun div() {
    }

    @Test
    fun mult() {
    }
}