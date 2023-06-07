public class NextDayCalculator {
    public static final String YearNotForMat = "Year Not Format";
    public static final String MonthNotForMat = "Month Not Format";
    public static final String DayNotForMat = "Day Not Format";

    public static String findNextDay(int day, int month, int year) {
        boolean isYear = year >= 0;
        if (!isYear) {
            return YearNotForMat;
        } else {
            Date date = new Date();
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    boolean isDay31 = day >= 1 && day <= 31;
                    if (!isDay31) {
                        return DayNotForMat;
                    } else {
                        int dayNumberOfMonth31 = 31;
                        Date newDateOfMonth31 = checkNextDay(day, month, year, dayNumberOfMonth31);
                        date = newDateOfMonth31;
                        break;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    boolean isDay30 = day >= 1 && day <= 30;
                    if (!isDay30) {
                        return DayNotForMat;
                    } else {
                        int dayNumberOfMonth30 = 30;
                        Date newDateOfMonth30 = checkNextDay(day, month, year, dayNumberOfMonth30);
                        date = newDateOfMonth30;
                        break;
                    }
                case 2:
                    boolean isLeapYear = isLeapYear(year);
                    if (isLeapYear) {
                        boolean isDay29 = day >= 1 && day <= 29;
                        if (!isDay29) {
                            return DayNotForMat;
                        } else {
                            int dayNumberOfMonth29 = 29;
                            Date newDateOfMonth29 = checkNextDay(day, month, year, dayNumberOfMonth29);
                            date = newDateOfMonth29;
                            break;
                        }
                    } else {
                        boolean isDay28 = day >= 1 && day <= 28;
                        if (!isDay28) {
                            return DayNotForMat;
                        } else {
                            int dayNumberOfMonth28 = 28;
                            Date newDateOfMonth28 = checkNextDay(day, month, year, dayNumberOfMonth28);
                            date = newDateOfMonth28;
                            break;
                        }
                    }
                default:
                    return MonthNotForMat;
            }
            return date.toString();
        }
    }

    private static boolean isLeapYear(int year) {
        boolean isLeapYearBy4 = year % 4 == 0;
        if (isLeapYearBy4) {
            boolean isLeapYear100 = year % 100 == 0;
            if (isLeapYear100) {
                boolean isLeapYear400 = year % 400 == 0;
                if (isLeapYear400) return true;
            } else return true;
        }
        return false;
    }

    private static Date checkNextDay(int day, int month, int year, int dayNumberOfMonth) {
        Date date = new Date(day, month, year);
        if (day == dayNumberOfMonth) {
            date.setDay(1);
            if (month == 12) {
                date.setMonth(1);
                date.setYear(++year);
            } else {
                date.setMonth(++month);
            }
        } else {
            date.setDay(++day);
        }
        return date;
    }

}

class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
