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
        val tennisGame = TennisGame()
                .player1Scores()
        assertThat(tennisGame, equalTo(TennisGame(player1Points = 15, player2Points = 0)))
    }

    @Test
    fun `if player one scores twice, then player1 has 30 points`() {
        val tennisGame = TennisGame()
                .player1Scores()
                .player1Scores()
        assertThat(tennisGame, equalTo(TennisGame(player1Points = 30, player2Points = 0)))
    }


    @Test
    fun `if player one scores three times in a row, then player1 has 40 points`() {
        val tennisGame = TennisGame()
                .player1Scores()
                .player1Scores()
                .player1Scores()
        assertThat(tennisGame, equalTo(TennisGame(player1Points = 40, player2Points = 0)))
    }

}

data class TennisGame(
    val player1Points: Int = 0,
    val player2Points: Int = 0
) {
    fun player1Scores(): TennisGame {
        if (player1Points == 30) {
            return TennisGame(player1Points = 40, player2Points = 0)
        }

        return TennisGame(player1Points = player1Points + 15, player2Points = 0)
    }
}