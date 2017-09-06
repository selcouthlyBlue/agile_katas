class ArabicToRomanNumeralConverter {
    String convert(int number) {
        StringBuilder resultingRomanNumeralString = new StringBuilder();
        for(RomanNumeral romanNumeral : RomanNumeral.sortedRomanNumeralsAccordingToTheirNumericalValues()){
            int romanNumeralValue = romanNumeral.getNumericValue();
            while(number >= romanNumeral.getNumericValue()){
                resultingRomanNumeralString.append(romanNumeral);
                number -= romanNumeralValue;
            }
        }
        return resultingRomanNumeralString.toString();
    }
}
