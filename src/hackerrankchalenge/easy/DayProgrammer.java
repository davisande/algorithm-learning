package hackerrankchalenge.easy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class DayProgrammer {
    private static final List<Integer> DAYS_MONTHS_YEAR = List.of(31, 28, 31, 30, 31, 30, 31, 31);
    private static final List<Integer> DAYS_MONTHS_LEAP_YEAR = List.of(31, 29, 31, 30, 31, 30, 31, 31);
    private static final List<Integer> DAYS_TRANSITION_YEAR = List.of(31, 15, 31, 30, 31, 30, 31, 31);

    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(2017));
        System.out.println(dayOfProgrammer(2016));
        System.out.println(dayOfProgrammer(1918));
    }

    public static String dayOfProgrammer(int year) {
        return Optional.of(year)
                .filter(y -> y < 1918)
                .map(DayProgrammer::getDateJulianCalendar)
                .orElse(calculateGregorianCalendar(year));
    }

    private static String getDateJulianCalendar(int year) {
        return Optional.of(year)
                .filter(y -> y % 4 == 0)
                .map(y -> getDate(y, DAYS_MONTHS_LEAP_YEAR))
                .orElse(getDate(year, DAYS_MONTHS_YEAR));
    }

    private static String calculateGregorianCalendar(int year) {
        return Optional.of(year)
                .filter(y -> y > 1918)
                .map(DayProgrammer::getDateGregorianCalendar)
                .orElse(calculateTransactionCalendar(year));
    }

    private static String getDateGregorianCalendar(int year) {
        return Optional.of(year)
                .filter(y -> y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))
                .map(y -> getDate(y, DAYS_MONTHS_LEAP_YEAR))
                .orElse(getDate(year, DAYS_MONTHS_YEAR));
    }

    private static String calculateTransactionCalendar(int year) {
        return Optional.of(year)
                .filter(y -> y == 1918)
                .map(y -> getDate(y, DAYS_TRANSITION_YEAR))
                .orElse("");
    }

    public static String noFunctionalProgramming(int year) {
        List<Integer> daysMonthsYear = List.of(31, 28, 31, 30, 31, 30, 31, 31);
        List<Integer> daysMonthsLeapYear = List.of(31, 29, 31, 30, 31, 30, 31, 31);
        List<Integer> daysTransitionYear = List.of(31, 15, 31, 30, 31, 30, 31, 31);

        String result;
        if (year < 1918) {
            if(year % 4 == 0) {
                result = getDate(year, daysMonthsLeapYear);
            } else {
                result = getDate(year, daysMonthsYear);
            }
        } else if (year > 1918) {
            if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                result = getDate(year, daysMonthsLeapYear);
            } else {
                result = getDate(year, daysMonthsYear);
            }
        } else {
            result = getDate(year, daysTransitionYear);
        }

        return result;
    }

    private static String getDate(int year, List<Integer> daysMonthsYear) {
        int amountDays = daysMonthsYear.stream().mapToInt(d -> d).sum();
        int month = daysMonthsYear.size() + 1;
        return Optional.of(amountDays)
                .map(a -> 256 - a)
                .map(day -> LocalDate.of(year, month, day))
                .map(date -> date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .orElseThrow();
    }


}
