package Ch_1_1_Basic_Programming_Model;

import edu.princeton.cs.algs4.StdOut;

/**
 * $ java-algs4 Practice_1_1_3.java 12 12 13
 * not equal
 * 
 * $ java-algs4 Practice_1_1_3.java 12 12 12
 * equal
 */
public class Practice_1_1_03 {
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
