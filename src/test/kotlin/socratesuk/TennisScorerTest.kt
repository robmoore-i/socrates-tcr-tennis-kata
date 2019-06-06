package socratesuk

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TennisScorerTest {
    @Test
    fun `game is initialised with player one with no points`() {
        val tennisGame = TennisGame()
        assertThat(tennisGame.player1Points, equalTo(0))
    }
}

class TennisGame {
    val player1Points: Int = 0
}