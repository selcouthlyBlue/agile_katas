import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TamagotchiTest {
    private Tamagotchi tamagotchi;

    @Before
    public void setUp() throws Exception {
        int startingHunger = 100;
        int startingFullness = 0;
        int startingHappiness = 50;
        int startingTiredness = 0;
        tamagotchi = new Tamagotchi.Builder("Chi Chi")
                .hunger(startingHunger)
                .fullness(startingFullness)
                .happiness(startingHappiness)
                .tiredness(startingTiredness).build();
    }

    @Test
    public void feedingATamagotchiDecreasesItsHungerAndIncreasesItsFullness() throws Exception {
        int fullnessGainedFromEatingFood = 25;
        int hungerLossFromEatingFood = 25;
        int expectedHunger = 75;
        int expectedFullness = 25;
        Food food = new Food(fullnessGainedFromEatingFood, hungerLossFromEatingFood);
        tamagotchi.feed(food);
        int hungerOfTamagotchi = tamagotchi.getHunger();
        int fullnessOfTamagotchi = tamagotchi.getFullness();
        assertTrue("Hunger is " + hungerOfTamagotchi, hungerOfTamagotchi == expectedHunger);
        assertTrue("Fullness is " + fullnessOfTamagotchi, fullnessOfTamagotchi == expectedFullness);
    }

    @Test
    public void playingWithTamagotchiShouldIncreaseItsHappinessAndAlsoItsTiredness() throws Exception {
        int expectedHappiness = 75;
        int expectedTiredness = 25;
        tamagotchi.play();
        int happinessOfTamagotchi = tamagotchi.getHappiness();
        int tirednessOfTamagotchi = tamagotchi.getTiredness();
        assertTrue("Happiness is " + happinessOfTamagotchi, happinessOfTamagotchi == expectedHappiness);
        assertTrue("Tiredness is " + tirednessOfTamagotchi, tirednessOfTamagotchi == expectedTiredness);
    }

    @Test
    public void puttingTamagotchiToBedShouldDecreaseItsTiredness() throws Exception {
        int expectedTiredness = 0;
        tamagotchi.play();
        tamagotchi.play();
        tamagotchi.goToBed();
        int tirednessOfTamagotchi = tamagotchi.getTiredness();
        assertTrue("Tiredness is " + tirednessOfTamagotchi, tirednessOfTamagotchi == expectedTiredness);
    }

    @Test
    public void makingTamagotchiPoopShouldDecreaseItsFullness() throws Exception {
        int fullnessGainedFromEatingFood = 25;
        int hungerLossFromEatingFood = 25;
        int expectedFullness = 15;
        Food food = new Food(fullnessGainedFromEatingFood, hungerLossFromEatingFood);
        tamagotchi.feed(food);
        tamagotchi.poop();
        int fullnessOfTamagotchi = tamagotchi.getFullness();
        assertTrue("Fullness is " + fullnessOfTamagotchi, fullnessOfTamagotchi == expectedFullness);
    }

    @Test
    public void feedingATamagotchiWhenItsFullShouldRaiseAnException() throws Exception {
        int fullnessGainedFromEatingFood = 25;
        int hungerLossFromEatingFood = 25;
        Food food = new Food(fullnessGainedFromEatingFood, hungerLossFromEatingFood);
        try{
            feedTamagotchiUntilItsFull(food);
            tamagotchi.feed(food);
            fail();
        } catch (TamagotchiIsFullException ignored) {
        }
    }

    @Test
    public void feedingATamagotchiShouldNotMakeItsHungerGoBelowTheMinimumValue() throws Exception {
        int fullnessGainedFromEatingFood = 25;
        int hungerLossFromEatingFood = 30;
        Food food = new Food(fullnessGainedFromEatingFood, hungerLossFromEatingFood);
        feedTamagotchiUntilItsFull(food);
        int hungerOfTamagotchi = tamagotchi.getHunger();
        assertFalse(hungerOfTamagotchi < Tamagotchi.MIN_STAT_VALUE);
    }

    private void feedTamagotchiUntilItsFull(Food food) throws TamagotchiIsFullException {
        tamagotchi.feed(food);
        tamagotchi.feed(food);
        tamagotchi.feed(food);
        tamagotchi.feed(food);
    }

    @Test
    public void playingWithTamagotchiShouldNotMakeItsHappinessGoAboveTheMaximumValue() throws Exception {
        tamagotchi.play();
        tamagotchi.play();
        tamagotchi.play();
        int happinessOfTamagotchi = tamagotchi.getHappiness();
        assertFalse(happinessOfTamagotchi > Tamagotchi.MAX_HAPPINESS);
    }

    @Test
    public void playingWithTamagotchiWhenItsTiredShouldRaiseAnException() throws Exception {
        try{
            tamagotchi.play();
            tamagotchi.play();
            tamagotchi.play();
            tamagotchi.play();
            tamagotchi.play();
            fail();
        } catch (TamagotchiIsTiredException ignored) {
        }
    }

    @Test
    public void puttingTamagotchiToBedWhenItsNotTiredShouldRaiseAnException() throws Exception {
        tamagotchi.play();
        tamagotchi.play();
        try{
            tamagotchi.goToBed();
            tamagotchi.goToBed();
            fail();
        } catch (TamagotchiIsNotTiredException ignored) {
        }
    }

    @Test
    public void makingTamagotchiPoopWhenItsNotFullShouldRaiseAnException() throws Exception {
        try{
            tamagotchi.poop();
            fail();
        } catch (TamagotchiIsNotFullException ignored) {
        }
    }
}