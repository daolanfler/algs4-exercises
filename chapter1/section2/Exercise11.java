package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise11 {

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
        SmartDate a = new SmartDate(2022, 12, 3);
        StdOut.println(a);
        SmartDate b = new SmartDate(2022, 2, 30);
        StdOut.println(b);
    }
}

/**
 * $ java-algs4 chapter1/section2/Exercise11.java
 * 12/3/2022
 * Exception in thread "main" java.lang.IllegalArgumentException: Illegal date
 * at chapter1.section2.Exercise11$SmartDate.<init>(Exercise11.java:14)
 * at chapter1.section2.Exercise11.main(Exercise11.java:50)
 */
