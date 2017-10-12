import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnakesAndLaddersGameTest {
    private SnakesAndLaddersGame snakesAndLaddersGame;
    private Player player1;

    @Before
    public void setUp() throws Exception {
        SpecialEnds specialEnds = new SpecialEnds();
        specialEnds.add(12, 2);
        specialEnds.add(3, 13);
        snakesAndLaddersGame = new SnakesAndLaddersGame(specialEnds);
        player1 = new Player("Rome");
        snakesAndLaddersGame.addPlayer(player1);
        snakesAndLaddersGame.determinePlayOrder();
    }

    @Test
    public void tokenShouldStartOnSquareOne() throws Exception {
        int expectedSquareLocation = 1;
        assertPlayerIsIn(player1, expectedSquareLocation);
    }

    @Test
    public void tokenShouldBeInSquare4AfterMoving3SpacesFromSquare1() throws Exception {
        int expectedSquareLocation = 4;
        int numberOfSpacesToMove = 3;
        turnPlayerMove(numberOfSpacesToMove);
        assertPlayerIsIn(player1, expectedSquareLocation);
    }

    @Test
    public void tokenShouldBeInSquare8AfterMoving3SpacesThen4SpacesFromSquare1() throws Exception {
        int expectedSquareLocation = 8;
        int firstNumberOfSpacesToMove = 3;
        int secondNumberOfSpacesToMove = 4;
        turnPlayerMove(firstNumberOfSpacesToMove);
        turnPlayerMove(secondNumberOfSpacesToMove);
        assertPlayerIsIn(player1, expectedSquareLocation);
    }

    private void turnPlayerMove(int spaces) {
        snakesAndLaddersGame.turnPlayerMove(spaces);
    }

    @Test
    public void numberOfMovesShouldBeDecidedByDieRolls() throws Exception {
        int dieResult = 1;
        int expectedSquareLocation = 5;
        while (dieResult != 4) {
            dieResult = player1.rollDice();
        }
        turnPlayerMove(dieResult);
        assertPlayerIsIn(player1, expectedSquareLocation);
    }

    @Test
    public void playerShouldWinTheGameWhenTheirTokenReachesThe100thSquare() throws Exception {
        turnPlayerMove(96);
        int numberOfSpacesToMove = 3;
        turnPlayerMove(numberOfSpacesToMove);
        assertEquals(player1, snakesAndLaddersGame.getWinner());
    }

    @Test
    public void playerShouldNotYetWinTheGameWhenTheirTokenMovementWillExceedThe100thSquare() throws Exception {
        turnPlayerMove(96);
        int numberOfSpacesToMove = 4;
        turnPlayerMove(numberOfSpacesToMove);
        assertNotEquals(player1, snakesAndLaddersGame.getWinner());
    }

    @Test
    public void tokenThatLandsOnASnakeHeadShouldGoDownOnTheTail() throws Exception {
        int expectedSquareLocation = 2;
        turnPlayerMove(11);
        assertPlayerIsIn(player1, expectedSquareLocation);
    }

    @Test
    public void tokenThatLandsOnASnakeTailShouldStayThere() throws Exception {
        int expectedSquareLocation = 2;
        turnPlayerMove(1);
        assertPlayerIsIn(player1, expectedSquareLocation);
    }

    @Test
    public void tokenThatLandsOnLowerEndOfTheLadderShouldGoUpTheLadder() throws Exception {
        int expectedSquareLocation = 13;
        turnPlayerMove(2);
        assertPlayerIsIn(player1, expectedSquareLocation);
    }

    @Test
    public void tokenThatLandsOnUpperEndOfTheLadderShouldStayThere() throws Exception {
        int expectedSquareLocation = 13;
        turnPlayerMove(12);
        assertPlayerIsIn(player1, expectedSquareLocation);
    }

    @Test
    public void player1ShouldBeFirstIfPlayer1RollsHigherThanPlayer2() throws Exception {
        Player player2 = new Player("Ein");
        snakesAndLaddersGame.addPlayer(player2);
        while (isNotFirstToRoll(player1))
            snakesAndLaddersGame.determinePlayOrder();
        assertTurnPlayerIs(player1);
    }

    @Test
    public void player2ShouldBeFirstIfPlayer2RollsHigherThanPlayer1() throws Exception {
        Player player2 = new Player("Ein");
        snakesAndLaddersGame.addPlayer(player2);
        while (isNotFirstToRoll(player2))
            snakesAndLaddersGame.determinePlayOrder();
        assertTurnPlayerIs(player2);
    }

    private void assertTurnPlayerIs(Player player2) {
        assertEquals(player2, snakesAndLaddersGame.getTurnPlayer());
    }

    @Test
    public void player2ShouldGoNextAfterPlayer1() throws Exception {
        Player player2 = new Player("Ein");
        snakesAndLaddersGame.addPlayer(player2);
        while (isNotFirstToRoll(player1))
            snakesAndLaddersGame.determinePlayOrder();
        turnPlayerMove(2);
        assertTurnPlayerIs(player2);
    }

    @Test
    public void player1ShouldGoNextAfterPlayer2GoingAfterPlayer1() throws Exception {
        Player player2 = new Player("Ein");
        snakesAndLaddersGame.addPlayer(player2);
        while (isNotFirstToRoll(player1))
            snakesAndLaddersGame.determinePlayOrder();
        turnPlayerMove(2);
        turnPlayerMove(2);
        assertTurnPlayerIs(player1);
    }

    private boolean isNotFirstToRoll(Player player) {
        return !player.equals(snakesAndLaddersGame.getTurnPlayer());
    }

    @Test
    public void computerShouldGoFirstIfComputerRollsHigherThanPlayer1() throws Exception {
        Player expectedTurnPlayer = new Player("COMPUTER");
        snakesAndLaddersGame.addComputerToGame();
        while (isNotFirstToRoll(expectedTurnPlayer))
            snakesAndLaddersGame.determinePlayOrder();
        assertTurnPlayerIs(expectedTurnPlayer);
    }

    @Test
    public void computerShouldBeAbleToRollTheDie() throws Exception {
        int expectedSquareLocation = 2;
        Player computer = new Player("COMPUTER");
        snakesAndLaddersGame.addComputerToGame();
        while (isNotFirstToRoll(computer))
            snakesAndLaddersGame.determinePlayOrder();
        turnPlayerMove(1);
        assertPlayerIsIn(computer, expectedSquareLocation);
    }

    private void assertPlayerIsIn(Player computer, int expectedSquareLocation) {
        assertTrue(snakesAndLaddersGame.getPositionOfTokenOf(computer) == expectedSquareLocation);
    }
}
