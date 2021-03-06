package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise14 {

    public static int lg(int N) {
        int m = 0;
        for (int i = N; i > 0; i /= 2)
            m++;
        return m - 1;
    }

    /**
     * $ java-algs4 Exercise14.java 100
     * Biggest integer <= log(2)100 is: 6
     */
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdOut.printf("Biggest integer <= log(2)%d is: %d \n", N, lg(N));
    }

}
