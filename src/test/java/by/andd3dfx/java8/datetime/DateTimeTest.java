package by.andd3dfx.java8.datetime;

import org.junit.Test;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateTimeTest {

    @Test
    public void clock() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date
    }

    @Test
    public void zoneId() {
        ZoneId.getAvailableZoneIds();   // all available timezone ids

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        var zoneRules1 = zone1.getRules();       // ZoneRules[currentStandardOffset=+01:00]
        var zoneRules2 = zone2.getRules();       // ZoneRules[currentStandardOffset=-03:00]
    }

    @Test
    public void localTime() {
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        var isNow1BeforeNow2 = now1.isBefore(now2);  // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);       // -3
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);   // -239

        LocalTime late = LocalTime.of(23, 59, 59);   // 23:59:59

        DateTimeFormatter germanFormatter = DateTimeFormatter
                .ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.GERMAN);

        LocalTime germanTime = LocalTime.parse("13:37", germanFormatter); // 13:37
    }

    @Test
    public void localDate() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();       // FRIDAY

        // Create LocalDate by parsing string:
        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);    // 2014-12-24
    }

    @Test
    public void localDateTime() {
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek = sylvester.getDayOfWeek(); // WEDNESDAY

        Month month = sylvester.getMonth();             // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);    // 1439

        // Get an instant:
        Instant instant = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Date legacyDate = Date.from(instant);       // Wed Dec 31 23:59:59 CET 2014

        // Formatting:
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("MMM dd, yyyy - HH:mm", Locale.US);

        LocalDateTime parsedLocalDateTime = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        String localDateTimeString = formatter.format(parsedLocalDateTime);   // Nov 03, 2014 - 07:13
    }
}
