import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("Joe");
    }

    @Test
    public void playerRollingADiceResultShouldBeBetween1and6inclusive() throws Exception {
        int result = player.rollDice();
        assertTrue(result >= 1 && result <= 6);
    }
}