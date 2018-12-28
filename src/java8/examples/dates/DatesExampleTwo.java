package java8.examples.dates;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by akhimitt on 8/5/2017.
 */
public class DatesExampleTwo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);

        Period p = Period.between(birthday, today);
        long p2 = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() + " months, and " + p.getDays() + " days old. (" + p2 + " days total)");

        LocalDate yesterday = today.minusDays(1);
        Duration.between(today.atTime(0, 0), yesterday.atTime(0, 0)).toDays(); // another option
    }
}
