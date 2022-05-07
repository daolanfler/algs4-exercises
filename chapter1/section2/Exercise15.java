package chapter1.section2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 基于 String 的 split() 方法实现 In 中的静态方法 readInts();
 */
public class Exercise15 {
    public static int[] readInts(String name) {
        In in = new In(name);
        String input = in.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ints[i] = Integer.parseInt(words[i]);
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] arr = readInts(args[0]);
        StdOut.println(Arrays.toString(arr));
    }
}

/**
 * $ java-algs4 chapter1/section2/Exercise15.java https://algs4.cs.princeton.edu/11model/tinyAllowlist.txt
 * [84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 33, 16, 77, 11, 29]
 */
