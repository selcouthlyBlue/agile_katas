public class RockPaperScissorsLizardSpockGame extends ThrowingGame {
    RockPaperScissorsLizardSpockGame(Player player, Player bot) {
        super(player, bot);
    }

    Gesture getWinningGesture(Gesture player1Gesture, Gesture player2Gesture) {
        switch (player1Gesture){
            case ROCK:
                switch (player2Gesture){
                    case SCISSORS: return Gesture.ROCK;
                    case PAPER: return Gesture.PAPER;
                }
                break;
            case SCISSORS:
                switch (player2Gesture){
                    case ROCK: return Gesture.ROCK;
                    case PAPER: return Gesture.SCISSORS;
                }
                break;
            case PAPER:
                switch (player2Gesture){
                    case SCISSORS: return Gesture.SCISSORS;
                    case ROCK: return Gesture.PAPER;
                }
                break;
        }
        return Gesture.DRAW;
    }
}
