package socratesuk

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TennisScorerTest {
    @Test
    fun `game is initialised with players with no points`() {
        val tennisGame = TennisGame()
        assertThat(tennisGame, equalTo(TennisGame(player1Points = TennisPoints(0), player2Points = TennisPoints(0))))
    }


    @Test
    fun `if player one scores, then player1 has 15 points`() {
        val tennisGame = TennisGame()
                .player1Scores()
        assertThat(tennisGame, equalTo(TennisGame(player1Points = TennisPoints(15), player2Points = TennisPoints(0))))
    }

    @Test
    fun `if player one scores twice, then player1 has 30 points`() {
        val tennisGame = TennisGame()
                .player1Scores()
                .player1Scores()
        assertThat(tennisGame, equalTo(TennisGame(player1Points = TennisPoints(30), player2Points = TennisPoints(0))))
    }

    @Test
    fun `if player one scores three times in a row, then player1 has 40 points`() {
        val tennisGame = TennisGame()
                .player1Scores()
                .player1Scores()
                .player1Scores()
        assertThat(tennisGame, equalTo(TennisGame(player1Points = TennisPoints(40), player2Points = TennisPoints(0))))
    }

    @Test
    fun `if player two scores they have 15 points`() {
        val tennisGame = TennisGame()
                .player2Scores()
        assertThat(tennisGame, equalTo(TennisGame(player1Points = TennisPoints(0), player2Points = TennisPoints(15))))
    }
}

data class TennisPoints(val points: Int = 0) {
    fun nextPoint(): TennisPoints {
        if (points == 0)
            return TennisPoints(15)
        else if (points == 15) {
            return TennisPoints(30)
        } else {
            return TennisPoints(40)
        }
    }
}

data class TennisGame(
        val player1Points: TennisPoints = TennisPoints(),
        val player2Points: TennisPoints = TennisPoints()
) {
    fun player1Scores(): TennisGame {
        return TennisGame(player1Points = player1Points.nextPoint(), player2Points = TennisPoints(0))
    }

    fun player2Scores(): TennisGame {
        return TennisGame(player1Points = TennisPoints(0), player2Points = player2Points.nextPoint())
    }
}