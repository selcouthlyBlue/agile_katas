public class Food {
    private int hungerLoss;
    private int fullnessGained;

    public Food(int fullnessGained, int hungerLoss) {
        this.fullnessGained = fullnessGained;
        this.hungerLoss = hungerLoss;
    }

    public int getHungerLoss() {
        return hungerLoss;
    }

    public int getFullnessGained() {
        return fullnessGained;
    }
}
