package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise16 {
    public static class Rational {
        private long numerator;
        private long denominator;

        public Rational(int numerator, int denominator) {
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

        public Rational plus(Rational b) {
            long numerator = this.numerator * b.denominator + b.numerator * this.denominator;
            long denominator = this.denominator * b.denominator;
            return new Rational((int) numerator, (int) denominator);
        }

        public Rational minus(Rational b) {
            long numerator = this.numerator * b.denominator - b.numerator * this.denominator;
            long denominator = this.denominator * b.denominator;
            return new Rational((int) numerator, (int) denominator);
        }

        public Rational multiply(Rational b) {
            long numerator = this.numerator * b.numerator;
            long denominator = this.denominator * b.denominator;
            return new Rational((int) numerator, (int) denominator);
        }

        public Rational divide(Rational b) {
            long numerator = this.numerator * b.denominator;
            long denominator = this.denominator * b.numerator;
            return new Rational((int) numerator, (int) denominator);
        }

        @Override
        public boolean equals(Object that) {
            if (that == this)
                return true;
            if (this.getClass() != that.getClass())
                return false;
            Rational r = (Rational) that;
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
            Rational a = new Rational(3, 4);
            Rational b = new Rational(6, 8);
            Rational c = new Rational(217, 712);

            StdOut.println("Check Plus: " + a + " + " + b + "? " + a.plus(b) + "  Expected: 3/2");
            StdOut.println("Check Minus: " + a + " - " + b + "? " + a.minus(b) + "  Expected: 0/1");
            StdOut.println("Check Multiply: " + a + " x " + b + "? " + a.multiply(b) + "  Expected: 9/16");
            StdOut.println("Check Divide: " + a + " / " + b + "? " + a.divide(b) + "  Expected: 1/1");
            StdOut.println("Check Equal: " + a + " == " + b + "? " + a.equals(b) + "  Expected: true");
            StdOut.println("Check Equal: " + a + " == " + c + "? " + a.equals(c) + "  Expected: false");
        }
    }

    public static void main(String[] args) {
        /**
         * Check Plus: 3/4 + 3/4? 3/2 Expected: 3/2
         * Check Minus: 3/4 - 3/4? 0/1 Expected: 0/1
         * Check Multiply: 3/4 x 3/4? 9/16 Expected: 9/16
         * Check Divide: 3/4 / 3/4? 1/1 Expected: 1/1
         * Check Equal: 3/4 == 3/4? true Expected: true
         * Check Equal: 3/4 == 217/712? false Expected: false
         */
    }
}
