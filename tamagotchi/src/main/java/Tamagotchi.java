public class Tamagotchi {
    private static final int MAX_FULLNESS = 100;
    static final int MIN_STAT_VALUE = 1;
    static final int MAX_HAPPINESS = 100;
    private static final int MAX_TIREDNESS = 100;
    private final String name;

    private int hunger;
    private int fullness;
    private int happiness;
    private int tiredness;

    private Tamagotchi(Builder builder) {
        this.name = builder.name;
        this.hunger = builder.hunger;
        this.fullness = builder.fullness;
        this.happiness = builder.happiness;
        this.tiredness = builder.tiredness;
    }

    void feed(Food food) throws TamagotchiIsFullException {
        increaseFullnessBy(food.getFullnessGained());
        decreaseHungerBy(food.getHungerLoss());
    }

    private void decreaseHungerBy(int hungerLossFromEatingFood) {
        hunger = Math.max(MIN_STAT_VALUE, hunger - hungerLossFromEatingFood);
    }

    private void increaseFullnessBy(int fullnessGainedFromEatingFood) throws TamagotchiIsFullException {
        if(tamgotchiWillGetReallyFullAfter(fullnessGainedFromEatingFood))
            throw new TamagotchiIsFullException(name + " is full!");
        fullness += fullnessGainedFromEatingFood;
    }

    private boolean tamgotchiWillGetReallyFullAfter(int fullnessGainedFromEatingFood) {
        return fullness + fullnessGainedFromEatingFood > MAX_FULLNESS;
    }


    void play() throws TamagotchiIsTiredException {
        increaseTirednessBy(25);
        increaseHappinessBy(25);
    }

    private void increaseTirednessBy(int tirednessGainedFromPlaying) throws TamagotchiIsTiredException {
        if(tamagotchiWillGetReallyTiredAfter(tirednessGainedFromPlaying))
            throw new TamagotchiIsTiredException(name + " is tired!");
        tiredness += tirednessGainedFromPlaying;
    }

    private boolean tamagotchiWillGetReallyTiredAfter(int tirednessGainedFromPlaying) {
        return tiredness + tirednessGainedFromPlaying > MAX_TIREDNESS;
    }

    private void increaseHappinessBy(int happinessGainedFromPlaying) {
        happiness = Math.min(happiness + happinessGainedFromPlaying, MAX_HAPPINESS);
    }

    void goToBed() throws TamagotchiIsNotTiredException {
        decreaseTiredness();
    }

    private void decreaseTiredness() throws TamagotchiIsNotTiredException {
        if(tiredness == 0)
            throw new TamagotchiIsNotTiredException(name + " is not tired!");
        int TIREDNESS_LOST_FROM_GOING_TO_BED = 50;
        tiredness = Math.min(0, tiredness - TIREDNESS_LOST_FROM_GOING_TO_BED);
    }

    void poop() throws TamagotchiIsNotFullException {
        decreaseFullness();
    }

    private void decreaseFullness() throws TamagotchiIsNotFullException {
        int FULLNESS_LOST_FROM_POOPING = 10;
        if(fullness - FULLNESS_LOST_FROM_POOPING < 0)
            throw new TamagotchiIsNotFullException(name + " doesn't have anything to poop!");
        fullness -= FULLNESS_LOST_FROM_POOPING;
    }

    int getHunger() {
        return hunger;
    }

    int getFullness() {
        return fullness;
    }

    int getHappiness() {
        return happiness;
    }

    int getTiredness() {
        return tiredness;
    }

    static class Builder{
        private final String name;
        private int hunger;
        private int fullness;
        private int happiness;
        private int tiredness;

        Builder(String name) {
            this.name = name;
        }

        Builder hunger(int startingHunger) {
            this.hunger = startingHunger;
            return this;
        }


        Builder fullness(int startingFullness) {
            this.fullness = startingFullness;
            return this;
        }

        Builder happiness(int startingHappiness){
            this.happiness = startingHappiness;
            return this;
        }

        Builder tiredness(int startingTiredness){
            this.tiredness = startingTiredness;
            return this;
        }

        Tamagotchi build() {
            return new Tamagotchi(this);
        }
    }
}
