package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise12 {
    public static class SmartDate {
        private final int year;
        private final int month;
        private final int day;

        public SmartDate(int year, int month, int day) {
            if (!isValidDate(year, month, day)) {
                throw new IllegalArgumentException("Illegal date");
            }
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int day() {
            return day;
        }

        public int year() {
            return year;
        }

        public int month() {
            return month;
        }

        public String toString() {
            return month() + "/" + day() + "/" + year();
        }

        public String dayOfTheWeek() {
            String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            Calendar calendar = Calendar.getInstance();
            Date date;
            try {
                date = new SimpleDateFormat("MM/dd/yyyy").parse(toString());
                calendar.setTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            int weekday = calendar.get(Calendar.DAY_OF_WEEK);
            return days[weekday - 1];
        }

        private boolean isValidDate(int year, int month, int day) {
            boolean valid = true;
            int[] maxNumberOfDaysPerMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (year < 1 || month < 1 || month > 12 || day < 1 || day > maxNumberOfDaysPerMonth[month - 1]) {
                valid = false;
            }
            return valid;
        }
    }

    public static void main(String[] args) {
        SmartDate a = new SmartDate(2022, 5, 4);
        StdOut.println(a.dayOfTheWeek() + " Expected: Wednesday");
        
        SmartDate b = new SmartDate(1989, 6, 4);
        StdOut.println(b.dayOfTheWeek() + " Expected: Sunday");
    }
}
