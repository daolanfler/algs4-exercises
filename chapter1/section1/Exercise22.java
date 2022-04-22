package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise22 {
    public static void main(String[] args) {
        int[] arr = new int[32];
        for (int i = 0; i < arr.length; i++)
            arr[i] = StdRandom.uniform(100);
        Arrays.sort(arr);
        StdOut.print("Sorted array is: ");
        for (int j : arr) StdOut.print(j + " ");
        StdOut.println();
        int key = StdRandom.uniform(100);
        StdOut.println("key is: " + key);
        int res = binarySearch(key, arr);
        StdOut.println(res);
    }

    public static int binarySearch(int key, int[] arr) {
        return rank(key, 0, arr.length - 1, arr, 0);
    }

    //    public static int rank(int key, int[] a) {
//        int lo = 0;
//        int hi = a.length - 1;
//        while (hi >= lo) {
//            int mid = (lo + hi) / 2;
//            if (a[mid] > key) hi = mid - 1;
//            else if (a[mid] < key) lo = mid + 1;
//            else return mid;
//        }
//        return -1;
//    }
    public static int rank(int key, int lo, int hi, int[] a, int level) {
        StdOut.println("  ".repeat(level) + "low: " + lo + " " + "high: " + hi);
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if (a[mid] > key) return rank(key, lo, mid - 1, a, ++level);
        else if (a[mid] < key) return rank(key, mid + 1, hi, a, ++level);
        else return mid;

    }
}
//    $ java-algs4 Exercise22.java
//        Sorted array is: 0 3 5 7 11 25 26 29 30 33 35 36 38 42 44 45 46 46 48 51 53 59 65 66 70 72 73 73 79 93 94 95
//        key is: 72
//        low: 0 high: 31
//        low: 16 high: 31
//        low: 24 high: 31
//        low: 24 high: 26
//        25
//
