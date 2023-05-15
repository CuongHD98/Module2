package ID9202;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {

    @Test
    void testFizzBuzzTranslateDivisibleByThree() {
        int actual = 3;
        String expected = "Fizz";
        String result = FizzBuzzTranslate.fizzBuzz(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzzTranslateDivisibleByFive() {
        int actual = 5;
        String expected = "Buzz";
        String result = FizzBuzzTranslate.fizzBuzz(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzzTranslateDivisibleByThreeAndFive() {
        int actual = 15;
        String expected = "FizzBuzz";
        String result = FizzBuzzTranslate.fizzBuzz(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzzTranslateNegativeNumber() {
        int actual = -1;
        String expected = "-1";
        String result = FizzBuzzTranslate.fizzBuzz(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzzTranslateHasThree() {
        int actual = 34;
        String expected = "Fizz";
        String result = FizzBuzzTranslate.fizzBuzz(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzzTranslateHasFive() {
        int actual = 59;
        String expected = "Buzz";
        String result = FizzBuzzTranslate.fizzBuzz(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzzTranslateHasThreeAndFive() {
        int actual = 53;
        String expected = "FizzBuzz";
        String result = FizzBuzzTranslate.fizzBuzz(actual);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzzTranslateNotHasThreeAndFive() {
        int actual = 74;
        String expected = "SevenFour";
        String result = FizzBuzzTranslate.fizzBuzz(actual);
        assertEquals(expected, result);
    }


}