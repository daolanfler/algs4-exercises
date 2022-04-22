package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise17 {
    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) return "";
        return s;
    }

    public static void main(String[] args) {
        String a = exR2(6);
        StdOut.println(a);
    }
}
//    $ java-algs4 Exercise17.java
//        Exception in thread "main" java.lang.StackOverflowError
//
