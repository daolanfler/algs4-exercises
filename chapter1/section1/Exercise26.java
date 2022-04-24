package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise26 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int t;
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }

        StdOut.println("Ascending order " + a + " " + b + " " + c);
    }
}
//    $ java-algs4 Exercise26.java 4 2 -12
//        Ascending order -12 2 4
