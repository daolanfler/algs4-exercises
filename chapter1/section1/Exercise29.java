package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise29 {
    public static int rank(int k, int[] arr) {
        int res = 0;
        for (int j : arr) {
            if (j < k) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    public static int count(int k, int[] arr) {
        int index = Exercise22.rankOriginal(k, arr);
        if (index == -1) return 0;
        // 二分查找拿到的不一定第一个 index
        int start = index;
        int end = index;
        while (start >= 0 && arr[start] == k) start--;
        while (end < arr.length && arr[end] == k) end++;
        start++;
        end--;
        return end - start + 1;

    }

    public static int[] randomArr() {
        int[] res = new int[40];
        for (int i = 0; i < 40; i++) {
            res[i] = StdRandom.uniform(40);
        }
        Arrays.sort(res);
        return res;

    }

    /**
     * [0, 0, 0, 1, 2, 2, 2, 6, 7, 7, 8, 8, 9, 9, 10, 10, 12, 18, 18, 19, 19, 20, 20, 21, 21, 24, 24, 25, 26, 26, 27, 29, 30, 32, 33, 33, 35, 35, 37, 38]
     * less than 15 count: 17
     * equal to 15 count: 0
     */
    public static void main(String[] args) {
        int[] arr = randomArr();
        StdOut.println(Arrays.toString(arr));
        StdOut.println("less than 15 count: " + rank(15, arr));
        StdOut.println("equal to 15 count: " + count(15, arr));
    }
}
