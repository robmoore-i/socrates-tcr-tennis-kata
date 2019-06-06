package socratesuk

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TennisScorerTest {
    @Test
    fun `game is initialised with players with no points`() {
        val tennisGame = TennisGame()
        assertThat(tennisGame, equalTo(TennisGame(player1Points = 0, player2Points = 0)))
    }


    @Test
    fun `if player one scores, then player1 has 15 points`() {
        var tennisGame = TennisGame()
        tennisGame = tennisGame.player1Scores()
        assertThat(tennisGame, equalTo(TennisGame(player1Points = 15, player2Points = 0)))
    }

}

data class TennisGame(
    val player1Points: Int = 0,
    val player2Points: Int = 0
) {
    fun player1Scores(): TennisGame {
        return TennisGame(player1Points = 15, player2Points = 0)
    }
}