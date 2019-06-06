package socratesuk

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TennisScorerTest {
    @Test
    fun `game is initialised with players with no points`() {
        val tennisGame = TennisGame()
        assertThat(tennisGame.player1Points, equalTo(0))
        assertThat(tennisGame.player2Points, equalTo(0))
    }

/*
    @Test
    fun `if player one scores, then player1 has 15 points`() {
        var tennisGame = TennisGame()
        tennisGame = tennisGame.player1Scores()
        assertThat(tennisGame.player1Points, equalTo(15))
    }
*/
}

data class TennisGame(
    val player1Points: Int = 0,
    val player2Points: Int = 0
) {

//    fun player1Scores(): TennisGame {
//        return TennisGame()
//    }
}