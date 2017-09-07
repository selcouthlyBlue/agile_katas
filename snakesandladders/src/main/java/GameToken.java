public class GameToken {
    private int squareLocation;

    public GameToken() {
        this.squareLocation = 1;
    }

    public int getSquareLocation() {
        return squareLocation;
    }

    public void move(int numberOfSpacesToMove) {
        squareLocation += numberOfSpacesToMove;
    }
}
