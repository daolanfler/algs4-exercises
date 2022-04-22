package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise19 {

    public static void main(String[] args) {
        StdOut.println("use array to cache: ");
        for (int N = 0; N <= 50; N++) {
            StdOut.println(N + " " + fib(N));
        }
        StdOut.println("\ndp: ");
        for (int N = 0; N <= 50; N++) {
            StdOut.println(N + " " + fib2(N));
        }
    }

    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 2) + F(N - 1);
    }

    public static long fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        long[] cache = new long[N + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            cache[i] = cache[i - 2] + cache[i - 1];
        }
        return cache[N];
    }

    public static long fib2(int N) {
        if (N == 0) return 0;
        long prev = 0, next = 1;
        while (N-- > 1) {
            long temp = next;
            next = next + prev;
            prev = temp;
        }
        return next;
    }
}
