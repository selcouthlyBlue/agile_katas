import java.util.Arrays;

public class BingoCard {
    private BingoColumn[] columns;

    public BingoCard() {
        this.columns = new BingoColumn[5];
        int i = 0;
        for(BingoColumnHead bingoColumnValue : BingoColumnHead.values()){
            columns[i] = new BingoColumn(bingoColumnValue);
            i++;
        }
    }

    public int getNumberOfSpaces() {
        return columns.length * 5;
    }

    public BingoColumn[] getColumns() {
        return columns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BingoCard bingoCard = (BingoCard) o;

        return Arrays.equals(columns, bingoCard.columns);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(columns);
    }

    @Override
    public String toString() {
        return "BingoCard{" +
                "columns=" + Arrays.toString(columns) +
                '}';
    }

    public boolean hasAllColumnsMarked() {
        for(BingoColumn column : columns){
            if(!column.hasAllSpacesMarked())
                return false;
        }
        return true;
    }

    public void mark(int numberCalled) {
        int columnIndex = getColumnIndex(numberCalled);
        columns[columnIndex].mark(numberCalled);
    }

    private int getColumnIndex(int numberCalled) {
        int columnIndex = numberCalled/15;
        if(numberCalled % 15 == 0)
            columnIndex -= 1;
        return columnIndex;
    }

    public boolean isMarked(int middleRowIndex, int middleColumnIndex) {
        return columns[middleColumnIndex].isMarked(middleRowIndex);
    }
}
