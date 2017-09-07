public class Square {
    private int destination;

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public boolean isYieldingToAnotherDestination() {
        return destination != 0;
    }

    public int getDestination() {
        return destination;
    }
}
