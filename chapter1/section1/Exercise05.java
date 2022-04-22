package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * $ java-algs4 Exercise05.java 0.3343 0
 * true
 * <p>
 * $ java-algs4 Exercise05.java 0.3343 1.2
 * false
 */
public class Exercise05 {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        if (isBetween(x) && isBetween(y)) {
            StdOut.println(true);
        } else {
            StdOut.println(false);
        }
    }

    public static boolean isBetween(double x) {
        return x <= 1 && x >= 0;
    }
}
