public class ConnectFourGame {
    private ConnectFourGrid connectFourGrid;

    public ConnectFourGame(int numberOfRows, int numberOfColumns) {
        connectFourGrid = new ConnectFourGrid(numberOfRows, numberOfColumns);
    }

    public void putTokenInColumn(GameToken gameToken, int columnNumber) throws GameIsOverException {
        int rowWhereTokenIsPlaced = connectFourGrid.putTokenInColumn(gameToken, columnNumber);
        checkIfGameIsOverByPlacingTokenIn(columnNumber, rowWhereTokenIsPlaced);
    }

    private void checkIfGameIsOverByPlacingTokenIn(int columnNumber, int rowWhereTokenIsPlaced) throws GameIsOverException {
        GameTokenColor[] connectingTokens = connectFourGrid.getRowOfTokensAlong(rowWhereTokenIsPlaced);
        checkIfThereAreFourConnectingTokensOfTheSameColorInConnectingTokensAlong(connectingTokens, columnNumber);
        connectingTokens = connectFourGrid.getColumnOfTokensAlong(columnNumber);
        checkIfThereAreFourConnectingTokensOfTheSameColorInConnectingTokensAlong(connectingTokens, rowWhereTokenIsPlaced);
        connectingTokens = connectFourGrid.getLeftDiagonalOfTokensAlong(columnNumber, rowWhereTokenIsPlaced);
        checkIfThereAreFourConnectingTokensOfTheSameColorInConnectingTokensAlong(connectingTokens, columnNumber);
        connectingTokens = connectFourGrid.getRightDiagonalOfTokensAlong(columnNumber, rowWhereTokenIsPlaced);
        checkIfThereAreFourConnectingTokensOfTheSameColorInConnectingTokensAlong(connectingTokens, columnNumber);
    }

    private void checkIfThereAreFourConnectingTokensOfTheSameColorInConnectingTokensAlong(GameTokenColor[] rowOfTokensWhereTokenIsPlaced, int columnWhereTokenIsPlaced) throws GameIsOverException {
        GameTokenColor colorOfPlacedToken = rowOfTokensWhereTokenIsPlaced[columnWhereTokenIsPlaced];
        int numberOfTokensHavingTheSameColorAsPlacedToken = 1;
        for(int increasingIndex = columnWhereTokenIsPlaced + 1; increasingIndex < rowOfTokensWhereTokenIsPlaced.length; increasingIndex++){
            if(areOfDifferentColors(colorOfPlacedToken, rowOfTokensWhereTokenIsPlaced[increasingIndex]))
                break;
            numberOfTokensHavingTheSameColorAsPlacedToken++;
            if(numberOfTokensHavingTheSameColorAsPlacedToken == 4)
                throw new GameIsOverException(colorOfPlacedToken + " wins!");
        }
        numberOfTokensHavingTheSameColorAsPlacedToken = 1;
        for(int decreasingIndex = columnWhereTokenIsPlaced - 1; decreasingIndex >= 0; decreasingIndex--){
            if(areOfDifferentColors(colorOfPlacedToken, rowOfTokensWhereTokenIsPlaced[decreasingIndex]))
                break;
            numberOfTokensHavingTheSameColorAsPlacedToken++;
            if(numberOfTokensHavingTheSameColorAsPlacedToken == 4)
                throw new GameIsOverException(colorOfPlacedToken + " wins!");
        }
    }

    private boolean areOfDifferentColors(GameTokenColor colorOfTokenPlaced, GameTokenColor colorOfConnectingToken) {
        return colorOfTokenPlaced != colorOfConnectingToken;
    }
}
