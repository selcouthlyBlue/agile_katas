import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class BingoColumn {
    private BingoSpace[] bingoSpaces;
    private BingoColumnHead bingoColumnValue;

    public BingoColumn(BingoColumnHead bingoColumnValue) {
        this.bingoSpaces = new BingoSpace[5];
        this.bingoColumnValue = bingoColumnValue;
        fillSpacesWithNumbers();
    }

    public BingoColumnHead getBingoColumnValue() {
        return bingoColumnValue;
    }

    private void fillSpacesWithNumbers() {
        List<Integer> numberLookUpTable = createNumberLookUpTable();
        for(int rowIndex = 0; rowIndex < 5; rowIndex++){
            fillSpaceAt(rowIndex, numberLookUpTable);
        }
    }

    private void fillSpaceAt(int rowIndex, List<Integer> numberLookUpTable) {
        Random rand = new Random();
        if(isMiddleSpace(rowIndex)){
            bingoSpaces[rowIndex] = new BingoSpace(0);
        } else {
            int numberToPlace = numberLookUpTable.remove(rand.nextInt(numberLookUpTable.size()));
            bingoSpaces[rowIndex] = new BingoSpace(numberToPlace);
        }
    }

    private boolean isMiddleSpace(int rowIndex) {
        return rowIndex == 2 && bingoColumnValue == BingoColumnHead.N;
    }

    private List<Integer> createNumberLookUpTable() {
        int[] numbers = IntStream.rangeClosed(bingoColumnValue.getLowerBound(), bingoColumnValue.getUpperBound()).toArray();
        List<Integer> numberLookUpTable = new ArrayList<>();
        for(int number : numbers){
            numberLookUpTable.add(number);
        }
        return numberLookUpTable;
    }

    public int getLowerBound() {
        return bingoColumnValue.getLowerBound();
    }

    public int getUpperBound() {
        return bingoColumnValue.getUpperBound();
    }

    public boolean hasAllSpacesMarked() {
        for(BingoSpace bingoSpace : bingoSpaces){
            if(!bingoSpace.isMarked()){
                return false;
            }
        }
        return true;
    }

    public void mark(int numberCalled) {
        for(BingoSpace bingoSpace : bingoSpaces){
            if(bingoSpace.contains(numberCalled)){
                bingoSpace.setAsMarked();
                break;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(bingoSpaces);
    }

    public boolean isMarked(int middleRowIndex) {
        return bingoSpaces[middleRowIndex].isMarked();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BingoColumn that = (BingoColumn) o;

        return Arrays.equals(bingoSpaces, that.bingoSpaces) && bingoColumnValue == that.bingoColumnValue;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(bingoSpaces);
        result = 31 * result + bingoColumnValue.hashCode();
        return result;
    }

    public int getNumberAt(int rowIndex) {
        return bingoSpaces[rowIndex].getNumber();
    }
}
