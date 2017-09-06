import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TennisScoreBoardTest {
    private TennisScoreBoard tennisScoreBoard;

    @Before
    public void setUp() throws Exception {
        tennisScoreBoard = new TennisScoreBoard();
    }

    @Test
    public void startingScoreIsZeroForBothPlayers() throws Exception {
        assertEquals("0", tennisScoreBoard.getServerScore().getTennisScoreValue());
        assertEquals("0", tennisScoreBoard.getReceiverScore().getTennisScoreValue());
    }

    @Test
    public void serverWinsAPointFromZero() throws Exception {
        tennisScoreBoard.awardServerAPoint();
        assertEquals("15", tennisScoreBoard.getServerScore().getTennisScoreValue());
        assertEquals("0", tennisScoreBoard.getReceiverScore().getTennisScoreValue());
    }

    @Test
    public void receiverWinsAPointFromZero() throws Exception {
        tennisScoreBoard.awardReceiverAPoint();
        assertEquals("0", tennisScoreBoard.getServerScore().getTennisScoreValue());
        assertEquals("15", tennisScoreBoard.getReceiverScore().getTennisScoreValue());
    }

    @Test
    public void advantageIsScoredCorrectly() throws Exception {
        while(!tennisScoreBoard.getServerScore().equals(TennisScores.FORTY))
            tennisScoreBoard.awardServerAPoint();
        while(!tennisScoreBoard.getReceiverScore().equals(TennisScores.FORTY))
            tennisScoreBoard.awardReceiverAPoint();
        tennisScoreBoard.awardServerAPoint();
        assertEquals("A", tennisScoreBoard.getServerScore().getTennisScoreValue());
        assertEquals("40", tennisScoreBoard.getReceiverScore().getTennisScoreValue());
    }

    @Test
    public void deuceIsScoredCorrectly() throws Exception {
        while(!tennisScoreBoard.getServerScore().equals(TennisScores.FORTY))
            tennisScoreBoard.awardServerAPoint();
        while(!tennisScoreBoard.getReceiverScore().equals(TennisScores.FORTY))
            tennisScoreBoard.awardReceiverAPoint();
        tennisScoreBoard.awardServerAPoint();
        tennisScoreBoard.awardReceiverAPoint();
        assertEquals("40", tennisScoreBoard.getServerScore().getTennisScoreValue());
        assertEquals("40", tennisScoreBoard.getReceiverScore().getTennisScoreValue());
    }

    @Test
    public void serverWinsTheGameFromForty() throws Exception {
        while(!tennisScoreBoard.getServerScore().equals(TennisScores.FORTY))
            tennisScoreBoard.awardServerAPoint();
        tennisScoreBoard.awardServerAPoint();
        assertEquals("WIN", tennisScoreBoard.getServerScore().getTennisScoreValue());
        assertEquals("0", tennisScoreBoard.getReceiverScore().getTennisScoreValue());
    }

    @Test
    public void receiverWinsTheGameFromAdvantage() throws Exception {
        while(!tennisScoreBoard.getServerScore().equals(TennisScores.FORTY))
            tennisScoreBoard.awardServerAPoint();
        while(!tennisScoreBoard.getReceiverScore().equals(TennisScores.ADVANTAGE))
            tennisScoreBoard.awardReceiverAPoint();
        tennisScoreBoard.awardReceiverAPoint();
        assertEquals("40", tennisScoreBoard.getServerScore().getTennisScoreValue());
        assertEquals("WIN", tennisScoreBoard.getReceiverScore().getTennisScoreValue());
    }

    @Test
    public void receiverWinsTheGameFromForty() throws Exception {
        while(!tennisScoreBoard.getReceiverScore().equals(TennisScores.FORTY))
            tennisScoreBoard.awardReceiverAPoint();
        tennisScoreBoard.awardReceiverAPoint();
        assertEquals("0", tennisScoreBoard.getServerScore().getTennisScoreValue());
        assertEquals("WIN", tennisScoreBoard.getReceiverScore().getTennisScoreValue());
    }
}