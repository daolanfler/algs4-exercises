package chapter1.section2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise9 {
    public static int rank(int key, int[] a, Counter counter) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            if (a[mid] > key) {
                hi = mid - 1;
                counter.increment();
            } else if (a[mid] < key) {
                lo = mid + 1;
                counter.increment();
            } else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        Counter rankCounter = new Counter("checked keys in rank");
        int[] arr = new int[32];
        for (int i = 0; i < arr.length; i++)
            arr[i] = StdRandom.uniform(100);
        Arrays.sort(arr);

        int k = StdRandom.uniform(100);
        rank(k, arr, rankCounter);
        StdOut.println(rankCounter);

    }
}

/**
 * FANG Qi@Helloween MINGW64 ~/Desktop/exercises (main)
 * $ java-algs4 chapter1/section2/Exercise9.java
 * 5 checked keys in rank
 */
