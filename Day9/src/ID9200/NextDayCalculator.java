package ID9200;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class NextDayCalculator {
    public static String findNextDay(String inputDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = dateFormat.parse(inputDate);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, 1);

            String nextDate = dateFormat.format(calendar.getTime());
            return nextDate;
//            System.out.println("Next Day is :  " + nextDate);
        } catch (ParseException e) {
            return "Invalid Date Format!";
        }
    }
}
