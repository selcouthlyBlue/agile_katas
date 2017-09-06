import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;

import static org.junit.Assert.*;

public class TennisScoresTest {
    @Test
    public void invalidTennisScore() throws Exception {
        int invalidTennisScoreValue = 6;
        try{
            TennisScores.getTennisScoreEquivalent(invalidTennisScoreValue);
            fail("Number should be considered invalid for a tennis score");
        } catch (InvalidTennisScoreException e) {
            assertEquals(invalidTennisScoreValue + " is an invalid tennis score value.", e.getMessage());
        }
    }
}