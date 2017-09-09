import java.util.*;

public class FizzBuzzGame {
    private SortedMap<Integer, String> substitutions;

    public FizzBuzzGame() {
        substitutions = new TreeMap<>();
    }

    public void addSubstitution(int number, String expectedSubstitution){
        substitutions.put(number, expectedSubstitution);
    }

    public String input(int number) {
        List<String> resultingString = new ArrayList<>();
        for(int key : substitutions.keySet())
            if(numberIsMultipleOf(number, key))
                resultingString.add(substitutions.get(key));
        if(resultingString.isEmpty())
            return String.valueOf(number);
        return String.join(" ", resultingString);
    }

    private boolean numberIsMultipleOf(int number, int key) {
        return number % key == 0;
    }
}
