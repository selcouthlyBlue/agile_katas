import java.util.Arrays;

public class Grid {
    private Column[] columns;

    public Grid(int numberOfRows, int numberOfColumns) {
        columns = new Column[numberOfColumns];
        for(int i = 0; i < columns.length; i++){
            columns[i] = new Column(numberOfRows);
        }
    }

    public Token[] getRightDiagonalOfTokensAlong(int columnWhereTokenIsPlaced, int rowWhereTokenIsPlaced) {
        Token[] tokens = new Token[getNumberOfColumns()];
        for(int rowNumber = rowWhereTokenIsPlaced, column = columnWhereTokenIsPlaced;
            rowNumber >= 0 && column < getNumberOfColumns();
            rowNumber--, column++)
            tokens[column] = getColorOfTokenPlacedIn(rowNumber, column);
        for(int rowNumber = rowWhereTokenIsPlaced, column = columnWhereTokenIsPlaced;
            rowNumber < getNumberOfRows() && column >= 0;
            rowNumber++, column--)
            tokens[column] = getColorOfTokenPlacedIn(rowNumber, column);
        return tokens;
    }

    public Token[] getLeftDiagonalOfTokensAlong(int columnWhereTokenIsPlaced, int rowWhereTokenIsPlaced) {
        Token[] tokens = new Token[getNumberOfColumns()];
        for(int rowNumber = rowWhereTokenIsPlaced, column = columnWhereTokenIsPlaced;
            rowNumber >= 0 && column >= 0;
            rowNumber--, column--)
            tokens[column] = getColorOfTokenPlacedIn(rowNumber, column);
        for(int rowNumber = rowWhereTokenIsPlaced, column = columnWhereTokenIsPlaced;
            rowNumber < getNumberOfRows() && column < getNumberOfColumns();
            rowNumber++, column++)
            tokens[column] = getColorOfTokenPlacedIn(rowNumber, column);
        return tokens;
    }

    public void put(Token token, int column) {
        checkIfColumnExists(column);
        columns[column].place(token);
    }

    private void checkIfColumnExists(int column) {
        if(column < 0 || column >= columns.length)
            throw new NonexistentColumnException(NonexistentColumnException.COLUMN_DOES_NOT_EXIST_MESSAGE);
    }

    public Token[] getColumnOfTokensAlong(int column) {
        Token[] tokens = new Token[getNumberOfColumns()];
        for(int rowNumber = 0; rowNumber < getNumberOfRows(); rowNumber++){
            tokens[rowNumber] = getColorOfTokenPlacedIn(rowNumber, column);
        }
        return tokens;
    }

    private Token getColorOfTokenPlacedIn(int rowWhereTokenIsPlaced, int column) {
        return columns[column].getColorOfTokenPlacedIn(rowWhereTokenIsPlaced);
    }

    public Token[] getRowOfTokensAlong(int rowWhereTokenIsPlaced) {
        Token[] tokens = new Token[getNumberOfColumns()];
        for(int column = 0; column < getNumberOfColumns(); column++){
            tokens[column] = getColorOfTokenPlacedIn(rowWhereTokenIsPlaced, column);
        }
        return tokens;
    }

    public int getNumberOfTokensIn(int column) {
        checkIfColumnExists(column);
        return columns[column].getCurrentNumberOfTokens();
    }

    public int getNumberOfRows() {
        return columns[0].getNumberOfRows();
    }

    public int getNumberOfColumns() {
        return columns.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = getNumberOfRows() - 1; i >= 0; i--){
            sb.append(Arrays.toString(getRowOfTokensAlong(i)));
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getRowWhereTokenIsPlaced(int column) {
        return columns[column].getCurrentNumberOfTokens() - 1;
    }
}
