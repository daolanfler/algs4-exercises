package Ch_1_1_Basic_Programming_Model;

import edu.princeton.cs.algs4.StdOut;

/**
 * $ java-algs4 Practice_1_1_6.java
 * 0
 * 1
 * 1
 * 2
 * 3
 * 5
 * 8
 * 13
 * 21
 * 34
 * 55
 * 89
 * 144
 * 233
 * 377
 * 610
 */
public class Practice_1_1_06 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            // 斐波那契数列
            f = f + g;
            g = f - g;
        }
    }
}
