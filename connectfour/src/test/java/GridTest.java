import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {
    private Token player1Token;
    private Token player2Token;
    private Grid grid;

    @Before
    public void setUp() throws Exception {
        int numberOfRows = 6;
        int numberOfColumns = 7;
        grid = new Grid(numberOfRows, numberOfColumns);
        player1Token = Token.BLUE;
        player2Token = Token.YELLOW;
    }

    @Test
    public void initializing6x7Grid() throws Exception {
        int expectedNumberOfRows = 6;
        int expectedNumberOfColumns = 7;
        assertTrue(expectedNumberOfRows == grid.getNumberOfRows());
        assertTrue(expectedNumberOfColumns == grid.getNumberOfColumns());
    }

    @Test
    public void checkingNumberOfTokensInANonExistentColumnShouldRaiseAnException() throws Exception {
        int nonExistentColumn = 7;
        try {
            grid.getNumberOfTokensIn(nonExistentColumn);
            fail();
        } catch (NonexistentColumnException e) {
            assertEquals(NonexistentColumnException.COLUMN_DOES_NOT_EXIST_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void puttingATokenInAnEmptyColumn() throws Exception {
        int column = 1;
        placePlayer1TokenIn(column);
        assertTrue(grid.getNumberOfTokensIn(column) == 1);
    }

    @Test
    public void puttingATokenInColumnWithFiveTokens() throws Exception {
        int column = 5;
        alternatelyPlaceSixTokensIn(column);
        assertTrue(grid.getNumberOfTokensIn(column) == 6);
    }

    @Test
    public void placingATokenInAColumnFilledWithTokensShouldRaiseAnException() throws Exception {
        int column = 6;
        alternatelyPlaceSixTokensIn(column);
        try{
            place(player2Token, column);
            fail();
        } catch (FullColumnException ignored) {
        }
    }

    private void alternatelyPlaceSixTokensIn(int column) {
        place(player1Token, column);
        place(player2Token, column);
        place(player1Token, column);
        place(player2Token, column);
        place(player1Token, column);
        place(player2Token, column);
    }

    private void place(Token token, int column) {
        grid.put(token, column);
    }

    private void placePlayer1TokenIn(int column) {
        grid.put(player1Token, column);
    }

    @Test
    public void placingATokenInANonExistentColumnShouldRaiseAnException() throws Exception {
        int nonExistentColumn = 7;
        try {
            placePlayer1TokenIn(nonExistentColumn);
            fail();
        } catch (NonexistentColumnException ignored) {
        }
    }
}