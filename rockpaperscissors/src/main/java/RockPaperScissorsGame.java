import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RockPaperScissorsGame extends ThrowingGame {
    private final List<Gesture> winningGestureDecider = new ArrayList<Gesture>(Arrays.asList(
            Gesture.ROCK,
            Gesture.SCISSORS,
            Gesture.PAPER)
    );

    RockPaperScissorsGame(Player player, Player bot) {
        super(player, bot);
    }

    Gesture getWinningGesture(Gesture player1Gesture, Gesture player2Gesture) {
        if(player1Gesture.equals(player2Gesture))
            return Gesture.DRAW;
        winningGestureDecider.remove(player1Gesture);
        winningGestureDecider.remove(player2Gesture);
        Gesture remainingGesture = winningGestureDecider.get(0);
        switch (remainingGesture){
            case ROCK: return Gesture.SCISSORS;
            case PAPER: return Gesture.ROCK;
            case SCISSORS: return Gesture.PAPER;
        }
        return Gesture.DRAW;
    }
}
