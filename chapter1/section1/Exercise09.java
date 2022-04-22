package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * $ java-algs4 Exercise09.java 123
 * 1111011
 */
public class Exercise09 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;
        StdOut.print(s);
    }

}
