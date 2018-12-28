package java8.examples.dates;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.util.concurrent.ScheduledExecutorService;

public class DatesExampleOne {
    public static void main(String[] args) {
        LocalDateTime timePoint = LocalDateTime.now();     // The current date and time
        //LocalDate.of(2012, Month.DECEMBER, 12); // from values
        //LocalTime.parse("10:15:30"); // From a String

        LocalDate theDate = timePoint.toLocalDate();
        Month month = timePoint.getMonth();
        int day = timePoint.getDayOfMonth();
        timePoint.getSecond();

        // Set the value, returning a new object
        LocalDateTime thePast = timePoint.withDayOfMonth(10).withYear(2010);
        LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.WEEKS);   // direct manipulation methods or pass a value and field pair

        Period period = Period.of(3, 2, 1); // A period represents distance on time line e.g. 3 years, 2 months, 1 day here.
        LocalDate newDate = theDate.plus(period);

    }
}
