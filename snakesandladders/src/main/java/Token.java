public class Token {
    private int location;

    public Token() {
        this.location = 1;
    }

    public int getLocation() {
        return location;
    }

    public void move(int spaces) {
        location += spaces;
    }
}
