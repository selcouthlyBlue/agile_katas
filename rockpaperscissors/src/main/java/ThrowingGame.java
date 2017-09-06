abstract class ThrowingGame {
    private Gesture winningGesture;
    private Gesture gestureChosenByPlayer1;
    private final Player player1;
    private final Player player2;
    static final String DRAW_MESSAGE = "It's a DRAW!";

    ThrowingGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    void decideWinningGesture(Gesture player1Gesture, Gesture player2Gesture){
        this.gestureChosenByPlayer1 = player1Gesture;
        this.winningGesture = getWinningGesture(player1Gesture, player2Gesture);
    }

    String getResult(){
        if(gameEndedInADraw())
            return DRAW_MESSAGE;
        if(player1Won())
            return player1.getName() + " wins!";
        else
            return player2.getName() + " wins!";
    }

    private boolean player1Won() {
        return gestureChosenByPlayer1.equals(winningGesture);
    }

    private boolean gameEndedInADraw() {
        return winningGesture.equals(Gesture.DRAW);
    }

    abstract Gesture getWinningGesture(Gesture player1Gesture, Gesture player2Gesture);
}
