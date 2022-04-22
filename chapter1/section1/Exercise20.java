package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise20 {
    public static void main(String[] args) {
        StdOut.println(ln(10));
    }

    public static double ln(int N) {
        if (N == 0) return 1;
        return Math.log(N) + ln(N - 1);
    }
}
