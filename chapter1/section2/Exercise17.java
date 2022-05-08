package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise17 {
    public static class RobustRational {
        private long numerator;
        private long denominator;
        private static final String OVERFLOW_MESSAGE = "Operation will cause overlow";

        public RobustRational(int numerator, int denominator) {
            // 分子 分母
            if (denominator == 0) {
                throw new IllegalArgumentException("denominator cannot be 0");
            }
            this.numerator = numerator;
            this.denominator = denominator;
            int gcd = gcd(numerator, denominator);

            this.numerator /= gcd;
            this.denominator /= gcd;
        }

        public RobustRational plus(RobustRational b) {
            long numerator = this.numerator * b.denominator + b.numerator * this.denominator;
            long denominator = this.denominator * b.denominator;
            validate(numerator, denominator);
            return new RobustRational((int) numerator, (int) denominator);
        }

        public RobustRational minus(RobustRational b) {
            long numerator = this.numerator * b.denominator - b.numerator * this.denominator;
            long denominator = this.denominator * b.denominator;
            validate(numerator, denominator);
            return new RobustRational((int) numerator, (int) denominator);
        }

        public RobustRational multiply(RobustRational b) {
            long numerator = this.numerator * b.numerator;
            long denominator = this.denominator * b.denominator;
            validate(numerator, denominator);
            return new RobustRational((int) numerator, (int) denominator);
        }

        public RobustRational divide(RobustRational b) {
            long numerator = this.numerator * b.denominator;
            long denominator = this.denominator * b.numerator;
            validate(numerator, denominator);
            return new RobustRational((int) numerator, (int) denominator);
        }

        private void validate(long numerator, long denominator) {
            assert numerator >= Integer.MIN_VALUE : OVERFLOW_MESSAGE;
            assert numerator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
            assert denominator >= Integer.MIN_VALUE : OVERFLOW_MESSAGE;
            assert denominator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        }

        @Override
        public boolean equals(Object that) {
            if (that == this)
                return true;
            if (that == null)
                return false;
            if (this.getClass() != that.getClass())
                return false;
            RobustRational r = (RobustRational) that;
            if (r.denominator != this.denominator)
                return false;
            if (r.numerator != this.numerator)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "" + numerator + "/" + denominator;
        }

        private int gcd(int a, int b) {
            if (b == 0)
                return a;
            return gcd(b, a % b);
        }

        public static void main(String[] args) {
            RobustRational a = new RobustRational(3, 4);
            RobustRational b = new RobustRational(6, 8);
            RobustRational c = new RobustRational(217, 712);

            StdOut.println("Check Plus: " + a + " + " + b + "? " + a.plus(b) + "  Expected: 3/2");
            StdOut.println("Check Minus: " + a + " - " + b + "? " + a.minus(b) + "  Expected: 0/1");
            StdOut.println("Check Multiply: " + a + " x " + b + "? " + a.multiply(b) + "  Expected: 9/16");
            StdOut.println("Check Divide: " + a + " / " + b + "? " + a.divide(b) + "  Expected: 1/1");
            StdOut.println("Check Equal: " + a + " == " + b + "? " + a.equals(b) + "  Expected: true");
            StdOut.println("Check Equal: " + a + " == " + c + "? " + a.equals(c) + "  Expected: false");

            // Would cause an overflow
            RobustRational r1 = new RobustRational(-2147483648, 1);
            RobustRational r2 = new RobustRational(-1, 1);
            r1.plus(r2);
            StdOut.println(r1.plus(r2));
        }
    }

    public static void main(String[] args) {
        // -enableassertions  开启
        /**
         * Check Plus: 3/4 + 3/4? 3/2 Expected: 3/2
         * Check Minus: 3/4 - 3/4? 0/1 Expected: 0/1
         * Check Multiply: 3/4 x 3/4? 9/16 Expected: 9/16
         * Check Divide: 3/4 / 3/4? 1/1 Expected: 1/1
         * Check Equal: 3/4 == 3/4? true Expected: true
         * Check Equal: 3/4 == 217/712? false Expected: false
         * Exception in thread "main" java.lang.AssertionError: Operation will cause
         * overlow
         * at chapter1.section2.Exercise17$RobustRational.validate(Exercise17.java:53)
         * at chapter1.section2.Exercise17$RobustRational.plus(Exercise17.java:27)
         * at chapter1.section2.Exercise17$RobustRational.main(Exercise17.java:101)
         */
    }
}
