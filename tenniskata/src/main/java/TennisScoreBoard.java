public class TennisScoreBoard {
    private int serverScore;
    private int receiverScore;

    public TennisScoreBoard() {
        this.serverScore = 0;
        this.receiverScore = 0;
    }

    public TennisScores getServerScore() {
        return TennisScores.getTennisScoreEquivalent(serverScore);
    }

    public TennisScores getReceiverScore() {
        return TennisScores.getTennisScoreEquivalent(receiverScore);
    }

    public void awardServerAPoint() {
        if(receiverHasScoreOfAdvantage())
            receiverScore = 3;
        else if(serverCanBeConsideredTheWinner())
            this.serverScore += 2;
        else
            this.serverScore += 1;
    }

    private boolean serverCanBeConsideredTheWinner() {
        return serverScore == 3 && receiverScore < 3;
    }

    private boolean receiverHasScoreOfAdvantage() {
        return receiverScore == 4 && serverScore == 3;
    }

    public void awardReceiverAPoint() {
        if(serverHasScoreOfAdvantage())
            serverScore = 3;
        else if(receiverCanBeConsideredTheWinner())
            this.receiverScore += 2;
        else
            this.receiverScore += 1;
    }

    private boolean receiverCanBeConsideredTheWinner() {
        return receiverScore == 3 && serverScore < 3;
    }

    private boolean serverHasScoreOfAdvantage() {
        return serverScore == 4 && receiverScore == 3;
    }
}
