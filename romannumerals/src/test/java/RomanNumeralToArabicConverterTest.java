import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralToArabicConverterTest {
    private RomanNumeralToArabicConverter converter;
    private int actualNumber;

    @Before
    public void setUp() throws Exception {
        converter = new RomanNumeralToArabicConverter();
    }

    @Test
    public void whenNumeralIisEnteredNumber1isExpected() throws Exception {
        int expectedNumber = 1;
        String romanNumeral = "I";
        convertToNumber(romanNumeral);
        assertRomanNumeralIsConvertedTo(expectedNumber);
    }

    @Test
    public void whenNumeralIIIisEnteredNumber3isExpected() throws Exception {
        int expectedNumber = 3;
        String romanNumeral = "III";
        convertToNumber(romanNumeral);
        assertRomanNumeralIsConvertedTo(expectedNumber);
    }

    @Test
    public void whenNumeralVisEnteredNumber5isExpected() throws Exception {
        int expectedNumber = 5;
        String romanNumeral = "V";
        convertToNumber(romanNumeral);
        assertRomanNumeralIsConvertedTo(expectedNumber);
    }

    @Test
    public void whenNumeralIXisEnteredNumber9isExpected() throws Exception {
        int expectedNumber = 9;
        String romanNumeral = "IX";
        convertToNumber(romanNumeral);
        assertRomanNumeralIsConvertedTo(expectedNumber);
    }

    @Test
    public void whenNumeralIVisEnteredNumber4isExpected() throws Exception {
        int expectedNumber = 4;
        String romanNumeral = "IV";
        convertToNumber(romanNumeral);
        assertRomanNumeralIsConvertedTo(expectedNumber);
    }

    @Test
    public void whenNumeralXLisEnteredNumber40isExpected() throws Exception {
        int expectedNumber = 40;
        String romanNumeral = "XL";
        convertToNumber(romanNumeral);
        assertRomanNumeralIsConvertedTo(expectedNumber);
    }

    @Test
    public void whenNumeralXCisEnteredNumber90isExpected() throws Exception {
        int expectedNumber = 90;
        String romanNumeral = "XC";
        convertToNumber(romanNumeral);
        assertRomanNumeralIsConvertedTo(expectedNumber);
    }

    @Test
    public void whenNumeralCDisEnteredNumber400isExpected() throws Exception {
        int expectedNumber = 400;
        String romanNumeral = "CD";
        convertToNumber(romanNumeral);
        assertRomanNumeralIsConvertedTo(expectedNumber);
    }

    @Test
    public void whenNumeralCMisEnteredNumber900isExpected() throws Exception {
        int expectedNumber = 900;
        String romanNumeral = "CM";
        convertToNumber(romanNumeral);
        assertRomanNumeralIsConvertedTo(expectedNumber);
    }

    @Test
    public void whenNumeralMLXVIisEnteredNumber1066isExpected() throws Exception {
        int expectedNumber = 1066;
        String romanNumeral = "MLXVI";
        convertToNumber(romanNumeral);
        assertRomanNumeralIsConvertedTo(expectedNumber);
    }

    @Test
    public void whenNumeralMCMLXXXIXisEnteredNumber1989isExpected() throws Exception {
        int expectedNumber = 1989;
        String romanNumeral = "MCMLXXXIX";
        convertToNumber(romanNumeral);
        assertRomanNumeralIsConvertedTo(expectedNumber);
    }

    private void convertToNumber(String romanNumeral) {
        actualNumber = converter.convert(romanNumeral);
    }

    private void assertRomanNumeralIsConvertedTo(int expectedNumber) {
        assertEquals(expectedNumber, actualNumber);
    }
}