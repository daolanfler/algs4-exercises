package Ch_1_1_Basic_Programming_Model;

import edu.princeton.cs.algs4.StdOut;

public class Practice_1_1_15 {
    public static int[] histogram(int[] arr, int M) {
        int[] res = new int[M];
        for (int i = 0; i < M; i++) {
            int count = 0;
            for (int k : arr) {
                if (k == i) count++;
            }
            res[i] = count;

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 6, 4, 2};
        int[] res = histogram(arr, 13);
        int sum = 0;
        for (int i : res) {
            StdOut.printf("%-2d", i);
            sum += i;
        }
        StdOut.println("\nsum of res and length of array is equal? ");
        StdOut.println(arr.length == sum);

    }
}
//    $ java-algs4 Practice_1_1_15.java
//        0 1 1 1 2 1 1 0 0 0 0 0 0
//        sum of res and length of array is equal?
//        true
