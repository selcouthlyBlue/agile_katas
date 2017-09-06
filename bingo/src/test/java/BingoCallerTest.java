import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BingoCallerTest {
    private BingoCaller bingoCaller;
    
    @Before
    public void setUp() throws Exception {
        bingoCaller = new BingoCaller();
    }

    @Test
    public void numberCalledShouldBeBetween1and75inclusive() throws Exception {
        int numberCalled = bingoCaller.getNumber();
        assertTrue(numberCalled >= 1 && numberCalled <= 75);
    }

    @Test
    public void eachNumberShouldBeCalledOnlyOnce() throws Exception {
        Set<Integer> numbersCalled = new HashSet<>();
        while(bingoCaller.getRemainingNumberOfBingoBalls() != 0){
            int numberCalled = bingoCaller.getNumber();
            if(numberIsCalledAlready(numbersCalled, numberCalled)){
                fail("Number " + numberCalled + " was already called.");
                break;
            }
            else {
                numbersCalled.add(numberCalled);
            }
        }
    }

    @Test
    public void gettingANumberFromAnEmptyBingoCallerShouldRaiseAnException() throws Exception {
        while(bingoCaller.getRemainingNumberOfBingoBalls() != 0){
            bingoCaller.getNumber();
        }
        try{
            bingoCaller.getNumber();
            fail();
        } catch (EmptyBingoCallerException e){
            assertEquals("Bingo caller is empty", e.getMessage());
        }
    }

    private boolean numberIsCalledAlready(Set<Integer> numbersCalled, int numberCalled) {
        return numbersCalled.contains(numberCalled);
    }
}