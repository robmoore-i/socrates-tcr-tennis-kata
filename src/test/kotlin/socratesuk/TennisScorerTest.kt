package socratesuk

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo

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



}

data class TennisPoints(val points: Int = 0){
}

data class TennisGame(
    val player1Points: TennisPoints = TennisPoints(),
    val player2Points:  TennisPoints = TennisPoints()
) {
    fun player1Scores(): TennisGame {
        if (player1Points.points == 30) {
            return TennisGame(player1Points = TennisPoints(40), player2Points = TennisPoints(0))
        }

        return TennisGame(player1Points = TennisPoints(player1Points.points + 15), player2Points = TennisPoints(0))
    }
}