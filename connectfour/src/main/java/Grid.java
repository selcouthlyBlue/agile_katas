import java.util.Arrays;

public class Grid {
    private final Token[][] grid;
    private final int[] currentNumbersOfTokens;

    public Grid(int numberOfRows, int numberOfColumns) {
        grid = new Token[numberOfRows][numberOfColumns];
        currentNumbersOfTokens = new int[numberOfColumns];
        Arrays.fill(currentNumbersOfTokens, 0);
        for(Token[] row : grid){
            Arrays.fill(row, Token.NULL_COLOR);
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
        checkIfColumnIsFull(column);
        grid[getNumberOfTokensIn(column)][column] = token;
        currentNumbersOfTokens[column]++;
    }

    private void checkIfColumnIsFull(int column) {
        if(getNumberOfTokensIn(column) >= getNumberOfRows())
            throw new InvalidGridOperationException(InvalidGridOperationException.COLUMN_IS_FULL_MESSAGE);
    }

    private void checkIfColumnExists(int column) {
        if(column < 0 || column >= grid[0].length)
            throw new InvalidGridOperationException(InvalidGridOperationException.COLUMN_DOES_NOT_EXIST_MESSAGE);
    }

    public Token[] getColumnOfTokensAlong(int column) {
        Token[] tokens = new Token[getNumberOfColumns()];
        for(int rowNumber = 0; rowNumber < getNumberOfRows(); rowNumber++){
            tokens[rowNumber] = getColorOfTokenPlacedIn(rowNumber, column);
        }
        return tokens;
    }

    private Token getColorOfTokenPlacedIn(int rowWhereTokenIsPlaced, int column) {
        return grid[rowWhereTokenIsPlaced][column];
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
        return currentNumbersOfTokens[column];
    }

    public int getNumberOfRows() {
        return grid.length;
    }

    public int getNumberOfColumns() {
        return grid[0].length;
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
        return currentNumbersOfTokens[column] - 1;
    }
}
