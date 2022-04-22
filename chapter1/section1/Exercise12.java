package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise12 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;

        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];

        for (int i = 0; i < 10; i++)
            StdOut.println(i + ", " + a[i]);
    }
}

// $ java-algs4 Exercise12.java
// 0, 0
// 1, 1
// 2, 2
// 3, 3
// 4, 4
// 5, 4
// 6, 3
// 7, 2
// 8, 1
// 9, 0
