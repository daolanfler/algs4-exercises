package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise18 {

    public static class Accumulator {
        private double m;
        private double s;
        private int N;

        public void addDataValue(double x) {
            N++;
            s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }

        public double mean() {
            return m;
        }

        public double var() {
            // unbiased sample variance 样本方差
            return s / (N - 1);
        }

        public double stddev() {
            // corrected sample standard deviation 样本标准差
            return Math.sqrt(this.var());
        }
       
        public String toString() {
            return "n = " + N + ", mean = " + mean() + ", stddev = " + stddev();
        }

        public static void main(String[] args) {
            Accumulator a = new Accumulator();
            
            a.addDataValue(1);
            a.addDataValue(2);
            a.addDataValue(1);

            StdOut.println("mean: " + a.mean() + " Expected: 1.333333");
            StdOut.println("var: " + a.var() + " Expected: 0.33333333333333");
            StdOut.println("stddev: " + a.stddev() + " Expected: 0.57735026918963");
            
        }
    }

    public static void main(String[] args) {
//        https://www.calculator.net/standard-deviation-calculator.html?numberinputs=1%2C+2%2C1&ctype=s&x=83&y=15
    }
}
