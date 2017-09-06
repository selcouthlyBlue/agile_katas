import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BingoGameTest {
    private BingoCaller bingoCaller;
    private BingoCard bingoCard;
    private BingoCardGenerator bingoCardGenerator = BingoCardGenerator.getInstance();

    @Before
    public void setUp() throws Exception {
        bingoCard = bingoCardGenerator.generateCard();
        bingoCaller = new BingoCaller();
    }

    @Test
    public void callingAllNumbersOnTheCardShouldResultToABingo() throws Exception {
        boolean isBingo = false;
        while(bingoCaller.getRemainingNumberOfBingoBalls() != 0 && !isBingo){
            int numberCalled = bingoCaller.getNumber();
            bingoCard.mark(numberCalled);
            if(bingoCard.hasAllColumnsMarked())
                isBingo = true;
        }
        if(!isBingo)
            fail();
    }

    @Test
    public void callingNoNumberOnTheCardShouldNotResultToABingo() throws Exception {
        boolean isBingo = bingoCard.hasAllColumnsMarked();
        if(isBingo)
            fail();
    }
}