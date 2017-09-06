public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public Gesture throwRock() {
        return Gesture.ROCK;
    }

    public Gesture throwScissors() {
        return Gesture.SCISSORS;
    }

    public Gesture throwPaper() {
        return Gesture.PAPER;
    }

    public String getName() {
        return name;
    }
}
