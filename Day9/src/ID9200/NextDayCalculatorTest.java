package ID9200;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void testFindNextDay1() throws ParseException {
        String actual = "01/01/2018";
        String expected = "02/01/2018";
        String result = NextDayCalculator.findNextDay(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFindNextDay2() throws ParseException {
        String actual = "31/01/2018";
        String expected = "01/02/2018";
        String result = NextDayCalculator.findNextDay(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFindNextDay3() throws ParseException {
        String actual = "30/04/2018";
        String expected = "01/05/2018";
        String result = NextDayCalculator.findNextDay(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFindNextDay4() throws ParseException {
        String actual = "28/02/2018";
        String expected = "01/03/2018";
        String result = NextDayCalculator.findNextDay(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFindNextDay5() throws ParseException {
        String actual = "29/02/2020";
        String expected = "01/03/2020";
        String result = NextDayCalculator.findNextDay(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFindNextDay6() throws ParseException {
        String actual = "31/12/2018";
        String expected = "01/01/2019";
        String result = NextDayCalculator.findNextDay(actual);
        assertEquals(expected, result);
    }
    @Test
    void testFindNextDayFalse() throws ParseException {
        String actual = "123FH1234";
        String expected = "Invalid Date Format!";
        String result = NextDayCalculator.findNextDay(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFindNextDay7() throws ParseException {
        String actual = "29/2/2020";
        String expected = "Invalid Date Format!";
        String result = NextDayCalculator.findNextDay(actual);
        assertEquals(expected, result);
    }

}