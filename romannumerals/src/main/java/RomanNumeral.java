import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum RomanNumeral {
    FOUR(4, "IV"), NINE(9, "IX"), FOURTY(40, "XL"),
    NINETY(90, "XC"), FOUR_HUNDRED(400, "CD"), NINE_HUNDRED(900, "CM"),
    ONE(1, "I"), FIVE(5, "V"), TEN(10, "X"),
    FIFTY(50, "L"),  ONE_HUNDRED(100, "C"), FIVE_HUNDRED(500, "D"),
    ONE_THOUSAND(1000, "M");

    private final int numericValue;
    private final String romanNumeralString;

    RomanNumeral(int numericValue, String romanNumeralString) {
        this.numericValue = numericValue;
        this.romanNumeralString = romanNumeralString;
    }

    @Override
    public String toString() {
        return this.romanNumeralString;
    }

    public int getNumericValue() {
        return numericValue;
    }

    public static RomanNumeral[] sortedRomanNumeralsAccordingToTheirNumericalValues(){
        List<RomanNumeral> romanNumerals = Arrays.asList(values());
        Collections.sort(romanNumerals, new Comparator<RomanNumeral>() {
            @Override
            public int compare(RomanNumeral firstRomanNumeral, RomanNumeral secondRomanNumeral) {
                if(firstRomanNumeral.numericValue > secondRomanNumeral.numericValue)
                    return -1;
                else if(firstRomanNumeral.numericValue < secondRomanNumeral.numericValue)
                    return 1;
                return 0;
            }
        });
        return (RomanNumeral[]) romanNumerals.toArray();
    }
}
