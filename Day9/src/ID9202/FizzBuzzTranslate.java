package ID9202;

public class FizzBuzzTranslate {
    public static final String DivisibleByThree = "Fizz";
    public static final String DivisibleByFive = "Buzz";
    public static final String NumberHasThree = "Fizz";
    public static final String NumberHasFive = "Buzz";
    public static final String[] NumberLessThanTenByString = {"Zero", "One", "Two", "Four", "Six", "Seven", "Eight", "Nice"};
    public static final char[] NumberLessThanTenByInteger = {'0', '1', '2', '4', '6', '7', '8', '9'};

    public static String fizzBuzz(int number) {
        boolean isPositiveNumberLessThan100 = number > 0 && number < 100;
        if (isPositiveNumberLessThan100) {
            String stringNumber = numberDivisibleByThreeOrFive(number);
            boolean isNotDivisibleThreeAndFive = stringNumber.equals(number + "");
            if (!isNotDivisibleThreeAndFive) {
                return stringNumber;
            } else return numberHasThreeOrFive(number);
        }
        return number + "";
    }

    public static String readNumberNotHasThreeAndFive(int number) {
        String stringNumber = String.valueOf(number);
        String readNumber = "";
        for (int i = 0; i < stringNumber.length(); i++) {
            for (int j = 0; j < NumberLessThanTenByInteger.length; j++) {
                boolean isEqualStringNumberThanNumber = stringNumber.charAt(i) == NumberLessThanTenByInteger[j];
                if (isEqualStringNumberThanNumber) {
                    readNumber += NumberLessThanTenByString[j];
                }
            }
        }
        return readNumber;
    }

    public static String numberDivisibleByThreeOrFive(int number) {
        boolean isDivisibleByThree = number % 3 == 0;
        boolean isDivisibleByFive = number % 5 == 0;
        if (isDivisibleByThree && isDivisibleByFive) return DivisibleByThree + DivisibleByFive;
        if (isDivisibleByThree) return DivisibleByThree;
        if (isDivisibleByFive) return DivisibleByFive;
        return number + "";
    }

    public static String numberHasThreeOrFive(int number) {
        String stringNumber = String.valueOf(number);
        boolean checkHasThree = false;
        boolean checkHasFive = false;
        for (int i = 0; i < stringNumber.length(); i++) {
            boolean isNumberHasThree = stringNumber.charAt(i) == '3';
            boolean isNumberHasFive = stringNumber.charAt(i) == '5';
            if (isNumberHasThree) checkHasThree = true;
            if (isNumberHasFive) checkHasFive = true;
        }
        if (checkHasThree && checkHasFive) return NumberHasThree + NumberHasFive;
        if (checkHasThree) return NumberHasThree;
        if (checkHasFive) return NumberHasFive;
        return readNumberNotHasThreeAndFive(number);
    }
}
