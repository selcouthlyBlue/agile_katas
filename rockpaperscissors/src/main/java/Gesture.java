public enum Gesture {
    ROCK, PAPER, SCISSORS, DRAW;

    @Override
    public String toString() {
        switch (this){
            case ROCK: return "rock";
            case PAPER: return "paper";
            case SCISSORS: return "scissors";
            case DRAW: return "draw";
        }
        return super.toString();
    }
}
