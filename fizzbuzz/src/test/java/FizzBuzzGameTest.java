import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzGameTest {
    private FizzBuzzGame fizzBuzzGame;
    private String result;

    @Before
    public void setUp() throws Exception {
        fizzBuzzGame = new FizzBuzzGame();
        initializeDefaultRules();
        initializeAdditionalRules();
    }

    private void initializeAdditionalRules() {
        fizzBuzzGame.addSubstitution(7, "pop");
    }

    private void initializeDefaultRules() {
        fizzBuzzGame.addSubstitution(3, "fizz");
        fizzBuzzGame.addSubstitution(5, "buzz");
    }

    @Test
    public void number1ShouldReturn1() throws Exception {
        int inputNumber = 1;
        String expectedResult = "1";
        input(inputNumber);
        assertResultIs(expectedResult);
    }

    @Test
    public void multipleOfThreeReturnsFizz() throws Exception {
        int inputNumber = 3;
        String expectedResult = "fizz";
        input(inputNumber);
        assertResultIs(expectedResult);
    }

    @Test
    public void multipleOfFiveShouldReturnBuzz() throws Exception {
        int inputNumber = 5;
        String expectedResult = "buzz";
        input(inputNumber);
        assertResultIs(expectedResult);
    }

    @Test
    public void multipleOfThreeAndFiveShouldReturnFizzBuzz() throws Exception {
        int inputNumber = 15;
        String expectedResult = "fizz buzz";
        input(inputNumber);
        assertResultIs(expectedResult);
    }

    @Test
    public void multipleOfSevenReturnPop() throws Exception {
        int inputNumber = 7;
        String expectedResult = "pop";
        input(inputNumber);
        assertResultIs(expectedResult);
    }

    @Test
    public void multipleOfThreeAndSevenReturnFizzPop() throws Exception {
        int inputNumber = 21;
        String expectedResult = "fizz pop";
        input(inputNumber);
        assertResultIs(expectedResult);
    }

    @Test
    public void multipleOfFiveAndSevenReturnBuzzPop() throws Exception {
        int inputNumber = 35;
        String expectedResult = "buzz pop";
        input(inputNumber);
        assertResultIs(expectedResult);
    }

    @Test
    public void multipleOfThreeFiveAndSevenShouldReturnFizzBuzzPop() throws Exception {
        int inputNumber = 105;
        String expectedResult = "fizz buzz pop";
        input(inputNumber);
        assertResultIs(expectedResult);
    }

    @Test
    public void multipleOfCustomNumberShouldReturnCustomSubstitution() throws Exception {
        int inputNumber = 2;
        String expectedSubstituteToInputNumber = "fuzz";
        String substituteToInputNumber = "fuzz";
        fizzBuzzGame.addSubstitution(inputNumber, substituteToInputNumber);
        input(inputNumber);
        assertResultIs(expectedSubstituteToInputNumber);
    }

    @Test
    public void linkingCustomSubstitutionsTogether() throws Exception {
        int inputNumber = 6;
        int firstCustomNumber = 2;
        int secondCustomNumber = 3;
        String firstCustomSubstitute = "fuzz";
        String secondCustomSubstitute = "bizz";
        String expectedSubstituteToInputNumber = "fuzz bizz";
        fizzBuzzGame.addSubstitution(firstCustomNumber, firstCustomSubstitute);
        fizzBuzzGame.addSubstitution(secondCustomNumber, secondCustomSubstitute);
        input(inputNumber);
        assertResultIs(expectedSubstituteToInputNumber);
    }

    private void input(int inputNumber) {
        result = fizzBuzzGame.input(inputNumber);
    }

    private void assertResultIs(String expectedResult) {
        assertTrue("Result was " + result, result.equals(expectedResult));
    }
}