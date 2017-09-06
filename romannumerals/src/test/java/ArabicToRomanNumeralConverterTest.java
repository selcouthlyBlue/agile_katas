import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArabicToRomanNumeralConverterTest {

    private ArabicToRomanNumeralConverter converter;
    private String actualRomanNumeral;

    @Before
    public void setUp() throws Exception {
        converter = new ArabicToRomanNumeralConverter();
    }

    @Test
    public void whenNumber1isEnteredNumeralIisExpected() throws Exception {
        String expectedRomanNumeral = "I";
        int number = 1;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    private void assertNumberIsConvertedTo(String expectedRomanNumeral) {
        assertEquals(expectedRomanNumeral, actualRomanNumeral);
    }

    @Test
    public void whenNumber3isEnteredNumeralIIIisExpceted() throws Exception {
        String expectedRomanNumeral = "III";
        int number = 3;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber5isEnteredNumeralVisExpected() throws Exception {
        String expectedRomanNumeral = "V";
        int number = 5;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber10isEnteredNumeralXisExpected() throws Exception {
        String expectedRomanNumeral = "X";
        int number = 10;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber50isEnteredNumeralLisExpected() throws Exception {
        String expectedRomanNumeral = "L";
        int number = 50;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber100isEnteredNumeralCisExpected() throws Exception {
        String expectedRomanNumeral = "C";
        int number = 100;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber500isEnteredNumeralDisExpected() throws Exception {
        String expectedRomanNumeral = "D";
        int number = 500;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber1000isEnteredNumeralMisExpected() throws Exception {
        String expectedRomanNumeral = "M";
        int number = 1000;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber4isEnteredNumeralIVisExpected() throws Exception {
        String expectedRomanNumeral = "IV";
        int number = 4;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber9isEnteredNumeralIXisExpected() throws Exception {
        String expectedRomanNumeral = "IX";
        int number = 9;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber40isEnteredNumeralXLisExpected() throws Exception {
        String expectedRomanNumeral = "XL";
        int number = 40;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber90isEnteredNumeralXCisExpected() throws Exception {
        String expectedRomanNumeral = "XC";
        int number = 90;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber400isEnteredNumeralCDisExpected() throws Exception {
        String expectedRomanNumeral = "CD";
        int number = 400;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber900isEnteredNumeralCMisExpected() throws Exception {
        String expectedRomanNumeral = "CM";
        int number = 900;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber1066isEnteredNumeralMLXVIisExpected() throws Exception {
        String expectedRomanNumeral = "MLXVI";
        int number = 1066;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    @Test
    public void whenNumber1989isEnteredNumeralMCMLXXXIXisExpected() throws Exception {
        String expectedRomanNumeral = "MCMLXXXIX";
        int number = 1989;
        convertToRomanNumeral(number);
        assertNumberIsConvertedTo(expectedRomanNumeral);
    }

    private void convertToRomanNumeral(int number) {
        actualRomanNumeral = converter.convert(number);
    }
}