import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextDayCalculatorTest {
    NextDayCalculator nextDayCalculator = new NextDayCalculator();

    @Test
    void findNextDay1() {
        int day = 29;
        int month = 2;
        int year = 2019;
        String actual = nextDayCalculator.findNextDay(day, month, year);
        String expected = "Day Not Format";
        assertEquals(expected, actual);
    }

    @Test
    void findNextDay2() {
        int day = 31;
        int month = 12;
        int year = 2019;
        String actual = nextDayCalculator.findNextDay(day, month, year);
        String expected = "1/1/2020";
        assertEquals(expected, actual);
    }

    @Test
    void findNextDay3() {
        int day = 28;
        int month = 2;
        int year = 2020;
        String actual = nextDayCalculator.findNextDay(day, month, year);
        String expected = "29/2/2020";
        assertEquals(expected, actual);
    }

    @Test
    void findNextDay4() {
        int day = 29;
        int month = 13;
        int year = -2019;
        String actual = nextDayCalculator.findNextDay(day, month, year);
        String expected = "Year Not Format";
        assertEquals(expected, actual);
    }

    @Test
    void findNextDay5() {
        int day = 29;
        int month = 13;
        int year = 2019;
        String actual = nextDayCalculator.findNextDay(day, month, year);
        String expected = "Month Not Format";
        assertEquals(expected, actual);
    }

}
