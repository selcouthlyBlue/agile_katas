import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RomanNumeralToArabicConverter {
    int convert(String romanNumeralString) {
        int resultingNumber = 0;
        for(RomanNumeral romanNumeral : RomanNumeral.values()){
            resultingNumber += romanNumeral.getNumericValue() * getNumberOfTimesRomanNumeralOccurredIn(romanNumeral, romanNumeralString);
            romanNumeralString = deleteAllOccurrencesOfRomanNumeralIn(romanNumeral, romanNumeralString);
        }
        return resultingNumber;
    }

    private String deleteAllOccurrencesOfRomanNumeralIn(RomanNumeral romanNumeral, String romanNumeralString) {
        return romanNumeralString.replaceAll(romanNumeral.toString(), "");
    }

    private int getNumberOfTimesRomanNumeralOccurredIn(RomanNumeral romanNumeral, String romanNumeralString) {
        int numberOfTimesTheRomanNumeralOccurred = 0;
        Pattern p = Pattern.compile(romanNumeral.toString());
        Matcher m = p.matcher(romanNumeralString);
        while(m.find()){
            numberOfTimesTheRomanNumeralOccurred++;
        }
        return numberOfTimesTheRomanNumeralOccurred;
    }
}
