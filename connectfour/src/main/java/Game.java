public class Game {
    private Grid grid;
    private int numberOfRequiredConnectingTokensOfSameColorToWin = 4;
    private Token winner;

    public Game(int numberOfRows, int numberOfColumns) {
        this.winner = Token.NULL_COLOR;
        this.grid = new Grid(numberOfRows, numberOfColumns);
    }

    public void put(Token token, int column) throws GameIsOverException {
        grid.put(token, column);
        if(placingTokenCompletesWinningSequence(column, grid.getRowWhereTokenIsPlaced(column)))
            winner = token;
    }

    private boolean placingTokenCompletesWinningSequence(int columnWhereTokenIsPlaced, int rowWhereTokenIsPlaced) {
        Token[] rowOfConnectingTokens = grid.getRowOfTokensAlong(rowWhereTokenIsPlaced);
        Token[] columnOfConnectingTokens = grid.getColumnOfTokensAlong(columnWhereTokenIsPlaced);
        Token[] leftDiagonalOfConnectingTokens = grid.getLeftDiagonalOfTokensAlong(columnWhereTokenIsPlaced, rowWhereTokenIsPlaced);
        Token[] rightDiagonalOfConnectingTokens = grid.getRightDiagonalOfTokensAlong(columnWhereTokenIsPlaced, rowWhereTokenIsPlaced);
        return hasWinningSequence(rowOfConnectingTokens, columnWhereTokenIsPlaced)
                || hasWinningSequence(columnOfConnectingTokens, rowWhereTokenIsPlaced)
                || hasWinningSequence(leftDiagonalOfConnectingTokens, columnWhereTokenIsPlaced)
                || hasWinningSequence(rightDiagonalOfConnectingTokens, columnWhereTokenIsPlaced);
    }

    private boolean hasWinningSequence(Token[] connectingTokens, int placedTokenIndex) {
        final int LEFT = 1;
        final int RIGHT = -1;
        return completesWinningSequence(connectingTokens, placedTokenIndex, LEFT) ||
                completesWinningSequence(connectingTokens, placedTokenIndex, RIGHT);
    }

    private boolean completesWinningSequence(Token[] connectingTokens, int currentlyPlacedTokenIndex, int direction) {
        int startingIndex = currentlyPlacedTokenIndex + (numberOfRequiredConnectingTokensOfSameColorToWin - 1) * -direction;
        int numberOfConnectingTokens = connectingTokens.length;
        if(!indexIsWithinBounds(startingIndex, numberOfConnectingTokens))
            return false;
        Token colorOfPlacedToken = connectingTokens[currentlyPlacedTokenIndex];
        for(int index = startingIndex; index != currentlyPlacedTokenIndex && indexIsWithinBounds(startingIndex, numberOfConnectingTokens); index += direction){
            if(areOfDifferentColors(colorOfPlacedToken, connectingTokens[index]))
                return false;
        }
        return true;
    }

    private boolean indexIsWithinBounds(int index, int upperBound) {
        return index >= 0 && index < upperBound;
    }

    private boolean areOfDifferentColors(Token colorOfTokenPlaced, Token colorOfConnectingToken) {
        return colorOfTokenPlaced != colorOfConnectingToken;
    }

    @Override
    public String toString() {
        return String.valueOf(grid);
    }

    public Token getWinner() {
        return winner;
    }
}
