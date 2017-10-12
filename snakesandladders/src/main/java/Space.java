public class Space {
    private int destination;

    public Space() {
        this.destination = -1;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public boolean isYieldingToAnotherDestination() {
        return destination != -1;
    }

    public int getDestination() {
        return destination;
    }
}
