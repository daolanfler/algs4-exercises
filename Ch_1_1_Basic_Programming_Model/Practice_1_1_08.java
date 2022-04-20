package Ch_1_1_Basic_Programming_Model;

import edu.princeton.cs.algs4.StdOut;

/**
 * $ java-algs4 Ch_1_1_Basic_Programming_Model/Practice_1_1_08.java
 * b
 * bc
 * 197
 * e
 */
public class Practice_1_1_08 {
    public static void main(String[] args) {
        System.out.println("b");

        System.out.println("b" + "c");

        // 单引号被提升至 int
        StdOut.println('b' + 'c');

        System.out.println((char) ('a' + 4));
    }
}
