public class Column {
    private Token[] column;
    private int currentIndex;

    public Column(int numberOfRows) {
        this.column = new Token[numberOfRows];
        this.currentIndex = 0;
    }

    public int getNumberOfRows() {
        return column.length;
    }

    public void place(Token token) {
        if(columnIsFull())
            throw new FullColumnException("Column is full!");
        column[currentIndex] = token;
        currentIndex++;
    }

    private boolean columnIsFull() {
        return currentIndex == column.length;
    }

    public int getCurrentNumberOfTokens() {
        return currentIndex;
    }

    public Token getColorOfTokenPlacedIn(int rowNumber) {
        if(column[rowNumber] == null)
            return Token.NULL_COLOR;
        return column[rowNumber];
    }
}
