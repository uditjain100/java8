package DateAndTime;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Tester {
    public static void main(String[] args) {
        // Prior to java 8
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date.toString());
        System.out.println(date.toInstant());
        System.out.println(date.toGMTString());
        System.out.println(date.toLocaleString());

        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        System.out.println(cal.getTimeZone());
        System.out.println(cal.getCalendarType());

        System.out.println(System.currentTimeMillis());

        // Java 8 and later
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(LocalDate.of(2024, 5, 2));
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfYear());

        System.out.println(localDate.minusDays(1));
        System.out.println(localDate.minusWeeks(1));
        System.out.println(localDate.minusMonths(1));
        System.out.println(localDate.minusYears(1));

        System.out.println(LocalDate.parse("2024-02-21"));

        System.out.println(localDate.isAfter(LocalDate.now()));

        // Local time
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(LocalTime.of(15, 26, 20));
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());

        System.out.println(localTime.minusHours(1));
        System.out.println(localTime.minusMinutes(1));
        System.out.println(localTime.minusSeconds(1));
        System.out.println(localTime.minusNanos(1));

        System.out.println(LocalTime.parse("15:22:08"));

        System.out.println(localTime.isAfter(LocalTime.now()));

        // Local date time -> combination of local time and local date

        // zoned date time => same as local date time with zone included
        ZonedDateTime zoned = ZonedDateTime.now();
        System.out.println(zoned);
        System.out.println(zoned.getZone());
        System.out.println(zoned.toInstant());

        // ZoneId.getAvailableZoneIds().forEach(System.out::println);

        System.out.println(ZonedDateTime.of(2024, 11, 5, 20, 20, 20, 500, ZoneId.systemDefault()));

        System.out.println(zoned.getDayOfMonth());
        System.out.println(zoned.getDayOfYear());
        System.out.println(zoned.getDayOfWeek());

        System.out.println(ZonedDateTime.parse("2024-08-05T04:39:08.513678800-07:00[America/Los_Angeles]"));

        // Instant -> give time in nano seconds
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(instant.getNano());
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());
        System.out.println(instant.minusNanos(1000000));
        System.out.println(instant.minusMillis(1000));
        System.out.println(instant.minusSeconds(100));

        // Duration
        System.out.println(Duration.ofSeconds(10));
        System.out.println(Duration.ofMillis(10000));
        System.out.println(Duration.ofMinutes(1));
        System.out.println(Duration.ofDays(1));
        System.out.println(Duration.ofHours(1));
        System.out.println(Duration.of(1, ChronoUnit.MINUTES));
        System.out.println(Duration.between(Instant.now().minusSeconds(25), Instant.now()));

        // Period -> for longer duration
        System.out.println(Period.ofDays(1));
        System.out.println(Period.ofMonths(1));
        System.out.println(Period.ofWeeks(1));
        System.out.println(Period.ofYears(1));
        System.out.println(Period.of(1, 1, 1));
        System.out.println(Period.between(localDate.minusDays(1), localDate));

        // Date Time formatter
        LocalDate formattedLocalDate = LocalDate.parse("2024/02/01", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(formattedLocalDate);

    }
}
