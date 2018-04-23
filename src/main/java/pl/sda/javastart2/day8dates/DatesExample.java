package pl.sda.javastart2.day8dates;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class DatesExample {
    public static void main(String[] args) {
        instant();
        duration();
        localDateTime();
        dateUtils();
    }

    private static void dateUtils() {
        Date date = new Date();
        Instant instant = date.toInstant();

        Date from = Date.from(instant);

        Calendar calendar = Calendar.getInstance();
        Instant calendarToInstant = calendar.toInstant();

        LocalDate now = LocalDate.now();

        System.out.println("Is leap year? " + now.isLeapYear());

        boolean before = now.isBefore(LocalDate.of(2004, 1, 2));

        System.out.println("3 weeks ago " + now.minusWeeks(3));

        System.out.println("First day of this month " + now.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastYearDay = now.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last day of this year " + lastYearDay);

        Period period = now.until(lastYearDay);
        System.out.println("Months from now to last day in year = "+period.getMonths());
    }

    private static void localDateTime() {
        LocalDateTime now = LocalDateTime.now();
        Date date = new Date();
        System.out.println("LocalDateTIme " + now);
        System.out.println("Date "+ date);
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        LocalDateTime of = LocalDateTime.of(localDate, localTime);
        System.out.println(of);

        LocalDateTime time = LocalDateTime.of(2014, Month.JANUARY, 12, 12, 8, 5, 6);
        System.out.println(time);

        LocalDateTime nowInTokyo = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Now in Tokyo: "+ nowInTokyo);
    }

    private static void duration() {
        Duration duration30Days = Duration.ofDays(30);
        System.out.println("30 days = " + duration30Days);
    }

    private static void instant() {
        Instant now = Instant.now();
        System.out.println("Current timestamp: " + now);

        Instant epochMilli = Instant.ofEpochMilli(3423644532245L);
        System.out.println("Specyfic time from epoch: " + epochMilli);
    }
}
