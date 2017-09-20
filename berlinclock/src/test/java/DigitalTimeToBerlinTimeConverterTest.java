import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DigitalTimeToBerlinTimeConverterTest {

    private DigitalTimeToBerlinTimeConverter digitalTimeToBerlinTimeConverter;

    @Before
    public void setUp() throws Exception {
        digitalTimeToBerlinTimeConverter = new DigitalTimeToBerlinTimeConverter();
    }

    @Test
    public void digitalTime00_00_00InBottomMinutes() throws Exception {
        String digitalTime = "00:00:00";
        assertForOOOOBottomMinutes(digitalTime);
    }

    @Test
    public void digitalTime23_59_59InBottomMinutes() throws Exception {
        String digitalTime = "23:59:59";
        assertForYYYYBottomMinutes(digitalTime);
    }

    private void assertForYYYYBottomMinutes(String digitalTime) {
        String berlinTime = digitalTimeToBerlinTimeConverter.getBottomMinutes(digitalTime);
        String expectedBerlinTime = "YYYY";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime12_32_00InBottomMinutes() throws Exception {
        String digitalTime = "12:32:00";
        String berlinTime = digitalTimeToBerlinTimeConverter.getBottomMinutes(digitalTime);
        String expectedBerlinTime = "YYOO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime12_34_00InSingleMinuteLampsRow() throws Exception {
        String digitalTime = "12:34:00";
        assertForYYYYBottomMinutes(digitalTime);
    }

    @Test
    public void digitalTime12_35_00InSingleMinuteLampsRow() throws Exception {
        String digitalTime = "12:35:00";
        assertForOOOOBottomMinutes(digitalTime);
    }

    private void assertForOOOOBottomMinutes(String digitalTime) {
        String berlinTime = digitalTimeToBerlinTimeConverter.getBottomMinutes(digitalTime);
        String expectedBerlinTime = "OOOO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    private void assertBerlinTimeIsExpected(String berlinTime, String expectedBerlinTime) {
        assertEquals(expectedBerlinTime, berlinTime);
    }

    @Test
    public void digitalTime00_00_00InTopMinutes() throws Exception {
        String digitalTime = "00:00:00";
        assertForOOOOOOOOOOOTopMinutes(digitalTime);
    }

    private void assertForOOOOOOOOOOOTopMinutes(String digitalTime) {
        String berlinTime = digitalTimeToBerlinTimeConverter.getTopMinutes(digitalTime);
        String expectedBerlinTime = "OOOOOOOOOOO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime23_59_59InTopMinutes() throws Exception {
        String digitalTime = "23:59:59";
        String berlinTime = digitalTimeToBerlinTimeConverter.getTopMinutes(digitalTime);
        String expectedBerlinTime = "YYRYYRYYRYY";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime12_04_00InTopMinutes() throws Exception {
        String digitalTime = "12:04:00";
        assertForOOOOOOOOOOOTopMinutes(digitalTime);
    }

    @Test
    public void digitalTime12_23_00InTopMinutes() throws Exception {
        String digitalTime = "12:23:00";
        String berlinTime = digitalTimeToBerlinTimeConverter.getTopMinutes(digitalTime);
        String expectedBerlinTime = "YYRYOOOOOOO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime12_35_00InTopMinutes() throws Exception {
        String digitalTime = "12:35:00";
        String berlinTime = digitalTimeToBerlinTimeConverter.getTopMinutes(digitalTime);
        String expectedBerlinTime = "YYRYYRYOOOO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime00_00_00InBottomHours() throws Exception {
        String digitalTime = "00:00:00";
        String berlinTime = digitalTimeToBerlinTimeConverter.getBottomHours(digitalTime);
        String expectedBerlinTime = "OOOO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime23_59_59InBottomHours() throws Exception {
        String digitalTime = "23:59:59";
        assertForRRROBottomHours(digitalTime);
    }

    private void assertForRRROBottomHours(String digitalTime) {
        String berlinTime = digitalTimeToBerlinTimeConverter.getBottomHours(digitalTime);
        String expectedBerlinTime = "RRRO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime02_04_00InBottomHours() throws Exception {
        String digitalTime = "02:04:00";
        String berlinTime = digitalTimeToBerlinTimeConverter.getBottomHours(digitalTime);
        String expectedBerlinTime = "RROO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime08_23_00InBottomHours() throws Exception {
        String digitalTime = "08:23:00";
        assertForRRROBottomHours(digitalTime);
    }

    @Test
    public void digitalTime14_35_00InBottomHours() throws Exception {
        String digitalTime = "14:35:00";
        String berlinTime = digitalTimeToBerlinTimeConverter.getBottomHours(digitalTime);
        String expectedBerlinTime = "RRRR";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime00_00_00InTopHours() throws Exception {
        String digitalTime = "00:00:00";
        assertForOOOOTopHours(digitalTime);
    }

    private void assertForOOOOTopHours(String digitalTime) {
        String berlinTime = digitalTimeToBerlinTimeConverter.getTopHours(digitalTime);
        String expectedBerlinTime = "OOOO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime23_59_59InTopHours() throws Exception {
        String digitalTime = "23:59:59";
        String berlinTime = digitalTimeToBerlinTimeConverter.getTopHours(digitalTime);
        String expectedBerlinTime = "RRRR";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime02_04_00InTopHours() throws Exception {
        String digitalTime = "02:04:00";
        assertForOOOOTopHours(digitalTime);
    }

    @Test
    public void digitalTime08_23_00InTopHours() throws Exception {
        String digitalTime = "08:23:00";
        String berlinTime = digitalTimeToBerlinTimeConverter.getTopHours(digitalTime);
        String expectedBerlinTime = "ROOO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime16_35_00InTopHours() throws Exception {
        String digitalTime = "16:35:00";
        String berlinTime = digitalTimeToBerlinTimeConverter.getTopHours(digitalTime);
        String expectedBerlinTime = "RRRO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime00_00_00InSeconds() throws Exception {
        String digitalTime = "00:00:00";
        String berlinTime = digitalTimeToBerlinTimeConverter.getSeconds(digitalTime);
        String expectedBerlinTime = "Y";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void digitalTime23_59_59InSeconds() throws Exception {
        String digitalTime = "23:59:59";
        String berlinTime = digitalTimeToBerlinTimeConverter.getSeconds(digitalTime);
        String expectedBerlinTime = "O";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void integratingTheEntireBerlinClockFor00_00_00() throws Exception {
        String digitalTime = "00:00:00";
        String berlinTime = digitalTimeToBerlinTimeConverter.getBerlinTime(digitalTime);
        String expectedBerlinTime = "YOOOOOOOOOOOOOOOOOOOOOOO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void integratingTheEntireBerlinClockFor23_59_59() throws Exception {
        String digitalTime = "23:59:59";
        String berlinTime = digitalTimeToBerlinTimeConverter.getBerlinTime(digitalTime);
        String expectedBerlinTime = "ORRRRRRROYYRYYRYYRYYYYYY";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void integratingTheEntireBerlinClockFor16_50_06() throws Exception {
        String digitalTime = "16:50:06";
        String berlinTime = digitalTimeToBerlinTimeConverter.getBerlinTime(digitalTime);
        String expectedBerlinTime = "YRRROROOOYYRYYRYYRYOOOOO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }

    @Test
    public void integratingTheEntireBerlinClockFor11_37_01() throws Exception {
        String digitalTime = "11:37:01";
        String berlinTime = digitalTimeToBerlinTimeConverter.getBerlinTime(digitalTime);
        String expectedBerlinTime = "ORROOROOOYYRYYRYOOOOYYOO";
        assertBerlinTimeIsExpected(berlinTime, expectedBerlinTime);
    }
}