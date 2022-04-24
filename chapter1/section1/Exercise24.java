package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise24 {
    public static int gcd(int p, int q) {
        StdOut.println(p + " " + q);
        if (p == 0) return q;
        if (q == 0) return p;
        if (p % q == 0) return q;
        return gcd(q, p % q);
    }

    public static void main(String[] args) {
        int res = gcd(105, 24);
        StdOut.println(res);

        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);

        int res2 = gcd(p, q);
        StdOut.println(res2);

        int res3 = gcd(5, 0);
        StdOut.println(res3);
    }
}
//    $ java-algs4 Exercise24.java 1111111 1234567
//        105 24
//        24 9
//        9 6
//        6 3
//        3
//        1111111 1234567
//        1234567 1111111
//        1111111 123456
//        123456 7
//        7 4
//        4 3
//        3 1
//        1
