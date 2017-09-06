import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RockPaperScissorsGameTest {

    private final Player player = new Player("Jerome");
    private final Player bot = new Player("Bot Bot");
    private ThrowingGame rockPaperScissorsGame;
    private Gesture gestureChosenByPlayer;
    private Gesture gestureChosenByBot;

    @Before
    public void setUp() throws Exception {
        rockPaperScissorsGame = new RockPaperScissorsGame(player, bot);
    }

    @Test
    public void playerRockBeatsBotScissors() throws Exception {
        playerThrowsRock();
        botThrowsScissors();
        decideGame();
        assertWinnerIs(player.getName());
    }

    private void playerThrowsRock() {
        gestureChosenByPlayer = player.throwRock();
    }

    private void botThrowsScissors() {
        gestureChosenByBot = bot.throwScissors();
    }

    @Test
    public void botRockBeatsPlayerScissors() throws Exception {
        playerThrowsScissors();
        botThrowsRock();
        decideGame();
        assertWinnerIs(bot.getName());
    }

    private void playerThrowsScissors() {
        gestureChosenByPlayer = player.throwScissors();
    }

    private void botThrowsRock() {
        gestureChosenByBot = bot.throwRock();
    }

    @Test
    public void playerScissorsBeatsBotPaper() throws Exception {
        playerThrowsScissors();
        botThrowsPaper();
        decideGame();
        assertWinnerIs(player.getName());
    }

    private void botThrowsPaper() {
        gestureChosenByBot = bot.throwPaper();
    }

    private void assertWinnerIs(String name) {
        String expectedWinningMessage = name + " wins!";
        assertEquals(expectedWinningMessage, rockPaperScissorsGame.getResult());
    }

    @Test
    public void botScissorsBeatsPlayerPaper() throws Exception {
        playerThrowsPaper();
        botThrowsScissors();
        decideGame();
        assertWinnerIs(bot.getName());
    }

    private void playerThrowsPaper() {
        gestureChosenByPlayer = player.throwPaper();
    }

    @Test
    public void playerPaperBeatsBotRock() throws Exception {
        playerThrowsPaper();
        botThrowsRock();
        decideGame();
        assertWinnerIs(player.getName());
    }

    @Test
    public void botPaperBeatsPlayerRock() throws Exception {
        playerThrowsRock();
        botThrowsPaper();
        decideGame();
        assertWinnerIs(bot.getName());
    }

    @Test
    public void botAndPlayerThrowingRockResultsInADraw() throws Exception {
        playerThrowsRock();
        botThrowsRock();
        decideGame();
        assertGameIsADraw();
    }

    private void assertGameIsADraw() {
        String expectedDrawMessage = ThrowingGame.DRAW_MESSAGE;
        assertEquals(expectedDrawMessage, rockPaperScissorsGame.getResult());
    }

    @Test
    public void botAndPlayerThrowingPaperResultsInADraw() throws Exception {
        playerThrowsPaper();
        botThrowsPaper();
        decideGame();
        assertGameIsADraw();
    }

    @Test
    public void botAndPlayerThrowingScissorsResultsInADraw() throws Exception {
        playerThrowsScissors();
        botThrowsScissors();
        decideGame();
        assertGameIsADraw();
    }

    private void decideGame() {
        rockPaperScissorsGame.decideWinningGesture(gestureChosenByPlayer, gestureChosenByBot);
    }
}