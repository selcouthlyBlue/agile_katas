import java.util.SortedMap;
import java.util.TreeMap;

public class FizzBuzzGame {
    private SortedMap<Integer, String> substitutions;

    public FizzBuzzGame() {
        substitutions = new TreeMap<Integer, String>();
    }

    public void addSubstitution(int number, String expectedSubstitution){
        substitutions.put(number, expectedSubstitution);
    }

    public String input(int number) {
        StringBuilder sb = new StringBuilder();
        boolean isMultipleOfPreviousNumber = false;
        for(int key : substitutions.keySet()){
            if(numberIsMultipleOf(number, key)){
                if(isMultipleOfPreviousNumber)
                    sb.append(" ");
                sb.append(substitutions.get(key));
                isMultipleOfPreviousNumber = true;
            }
        }
        if(!isMultipleOfPreviousNumber)
            return String.valueOf(number);
        return sb.toString();
    }

    private boolean numberIsMultipleOf(int number, int key) {
        return number % key == 0;
    }
}
