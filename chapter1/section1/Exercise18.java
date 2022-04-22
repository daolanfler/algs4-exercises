package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise18 {
    // returns a * b  a + 2a + 4a + ... 2^(log<2>(b+1) -1) * a = a * b
    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    // returns a * a^2 * ....a^(log<2>(b+1) - 1) = a^b
    public static int mystery2(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery2(a * a, b / 2);
        return mystery2(a * a, b / 2) * a;
    }

    public static void main(String[] args) {
        int res1 = mystery(2, 25);
        int res2 = mystery(3, 11);
        int res3 = mystery(3, 12);
        StdOut.println(res1);
        StdOut.println(res2);
        StdOut.println(res3);

        StdOut.println(mystery2(2, 8));
    }
}
//    $ java-algs4 Exercise18.java
//        50
//        33
//        36
//        256
