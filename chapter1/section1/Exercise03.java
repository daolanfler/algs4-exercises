package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * $ java-algs4 Exercise03.java 12 12 13
 * not equal
 * <p>
 * $ java-algs4 Exercise03.java 12 12 12
 * equal
 */
public class Exercise03 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if (a == b && b == c) {
            StdOut.println("equal");
        } else {
            StdOut.println("not equal");
        }
    }
}
