import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BingoCardGeneratorTest {

    private BingoCardGenerator bingoCardGenerator = BingoCardGenerator.getInstance();
    private BingoCard bingoCard;

    @Before
    public void setUp() throws Exception {
        bingoCard = bingoCardGenerator.generateCard();
    }

    @Test
    public void bingoCardShouldHave25Spaces() throws Exception {
        int requiredNumberOfSpaces = 25;
        BingoCard bingoCard = bingoCardGenerator.generateCard();
        assertTrue(bingoCard.getNumberOfSpaces() == requiredNumberOfSpaces);
    }

    @Test
    public void bingoCardShouldHave25UniqueSpaces() throws Exception {
        Set<Integer> numbersInTheBingoCard = new HashSet<>();
        for(BingoColumn column : bingoCard.getColumns()){
            for(int rowIndex = 0; rowIndex < 5; rowIndex++){
                int numberChecked = column.getNumberAt(rowIndex);
                if(numbersInTheBingoCard.contains(numberChecked)){
                    fail("Bingo card contains duplicate number: " + numberChecked);
                    return;
                }
                numbersInTheBingoCard.add(numberChecked);
            }
        }
    }

    @Test
    public void bingoCardShouldContainNumbersBetweenBoundsInclusiveToEachColumn() throws Exception {
        for(BingoColumn column : bingoCard.getColumns()){
            for(int rowIndex = 0; rowIndex < 5; rowIndex++){
                int numberChecked = column.getNumberAt(rowIndex);
                if(!isBetweenBoundsInclusiveToColumn(numberChecked, column) && isMiddle(column)){
                    fail("Number " + numberChecked + " does not belong to " + column.getBingoColumnValue());
                    return;
                }
            }
        }
    }

    private boolean isMiddle(BingoColumn column) {
        return column.getBingoColumnValue() != BingoColumnHead.N;
    }

    @Test
    public void bingoCardShouldHaveAFREESpaceInTheMiddle() throws Exception {
        int middleRowIndex = 2;
        int middleColumnIndex = 2;
        if(!bingoCard.isMarked(middleRowIndex, middleColumnIndex)){
            fail();
        }
    }

    private boolean isBetweenBoundsInclusiveToColumn(int number, BingoColumn bingoColumn) {
        return number >= bingoColumn.getLowerBound() && number <= bingoColumn.getUpperBound();
    }
}