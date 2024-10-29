package Backend.Weather.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Util {


    public static String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline";

    public static boolean validateDateRange(String startDate, String endDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        return end.isAfter(start) || end.isEqual(start);

    }

    public static String getCurrentDate() {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate curDate = LocalDate.now();
        return curDate.format(format);
    }
}
