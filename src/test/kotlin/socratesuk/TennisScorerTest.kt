package socratesuk

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
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

    @Test
    fun `if player one scores then player two scores they both have 15 points`() {
        val tennisGame = TennisGame()
                .player1Scores()
                .player2Scores()
        assertThat(tennisGame, equalTo(TennisGame(player1Points = TennisPoints(15), player2Points = TennisPoints(15))))
    }

    @Test
    fun `if player 1 is on 40 and player 2 is on 30 then when player 2 scores there is a deuce`() {
        val tennisGame = TennisGame(TennisPoints(40), TennisPoints(30)).player2Scores()
        assertTrue(tennisGame.deuce)
    }

    @Test
    fun `if player 1 is on 40 and scores, then player 1 wins`() {
        val tennisGame = TennisGame(TennisPoints(40), TennisPoints(30)).player1Scores()
        assertTrue(tennisGame.player1Won)
        assertThat(tennisGame.player1Points, equalTo(TennisPoints(45)))
        assertFalse(tennisGame.player2Won)
        assertThat(tennisGame.player2Points, equalTo(TennisPoints(30)))
    }

    @Test
    fun `if player 2 is on 40 and scores, then player 2 wins`() {
        val tennisGame = TennisGame(TennisPoints(30), TennisPoints(40)).player2Scores()
        assertFalse(tennisGame.player1Won)
        assertThat(tennisGame.player1Points, equalTo(TennisPoints(30)))
        assertTrue(tennisGame.player2Won)
        assertThat(tennisGame.player2Points, equalTo(TennisPoints(45)))

    }
}

data class TennisPoints(val value: Int = 0) {
    fun nextPoint() = when (value) {
        0 -> TennisPoints(15)
        15 -> TennisPoints(30)
        30 -> TennisPoints(40)
        else -> TennisPoints(45)
    }
}

data class TennisGame(
        val player1Points: TennisPoints = TennisPoints(),
        val player2Points: TennisPoints = TennisPoints()
) {
    val player1Won = player1Points.value == 45
    val player2Won = player2Points.value == 45
    val deuce: Boolean = player1Points.value == 40 && player2Points.value == 40

    fun player1Scores(): TennisGame {
        return copy(player1Points = player1Points.nextPoint())
    }

    fun player2Scores(): TennisGame {
        return copy(player2Points = player2Points.nextPoint())
    }
}