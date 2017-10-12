import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;
    private Token player1Token;
    private Token player2Token;

    @Before
    public void setUp() throws Exception {
        int numberOfRows = 6;
        int numberOfColumns = 7;
        game = new Game(numberOfRows, numberOfColumns);
        player1Token = Token.BLUE;
        player2Token = Token.YELLOW;
    }

    @Test
    public void aPlayerConnectingFourHorizontalTokensOfSameColorShouldWinTheGame() throws Exception {
        game.put(player1Token, 0);
        game.put(player1Token, 1);
        game.put(player1Token, 2);
        game.put(player1Token, 3);
        assertWinnerIs(player1Token);
    }

    private void assertWinnerIs(Token token) {
        assertTrue(game.getWinner() == token);
    }

    @Test
    public void aPlayerConnectingFourVerticalTokensOfSameColorShouldWinTheGame() throws Exception {
        game.put(player2Token, 0);
        game.put(player2Token, 0);
        game.put(player2Token, 0);
        game.put(player2Token, 0);
        assertWinnerIs(player2Token);
    }

    @Test
    public void aPlayerNotConnectingFourVerticalTokensOfSameColorShouldNotWinTheGameYet() throws Exception {
        game.put(player2Token, 0);
        assertWinnerIs(Token.NULL_COLOR);
    }

    @Test
    public void aPlayerConnectingFourLeftDiagonalTokensOfSameColorShouldWinTheGame() throws Exception {
        game.put(player1Token, 0);
        game.put(player2Token, 1);
        game.put(player1Token, 2);
        game.put(player2Token, 3);
        game.put(player1Token, 0);
        game.put(player2Token, 2);
        game.put(player1Token, 1);
        game.put(player2Token, 3);
        game.put(player1Token, 2);
        game.put(player2Token, 0);
        game.put(player2Token, 1);
        game.put(player2Token, 3);
        game.put(player1Token, 0);
        game.put(player2Token, 1);
        game.put(player1Token, 2);
        game.put(player1Token, 3);
        assertWinnerIs(player1Token);
    }

    @Test
    public void aPlayerConnectingFourRightDiagonalTokensShouldWinTheGame() throws Exception {
        game.put(player1Token, 0);
        game.put(player1Token, 0);
        game.put(player2Token, 0);
        game.put(player2Token, 0);
        game.put(player2Token, 1);
        game.put(player1Token, 1);
        game.put(player2Token, 1);
        game.put(player2Token, 1);
        game.put(player1Token, 2);
        game.put(player2Token, 2);
        game.put(player1Token, 2);
        game.put(player1Token, 2);
        game.put(player2Token, 3);
        assertWinnerIs(player2Token);
    }
}