package chapter1.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import utils.Constants;

import java.util.Arrays;

public class Exercise28 {
    public static void main(String[] args) {
        // args[0] 是测试数据存放的路径 relative to Constants.FILE_PATH
        String path = Constants.FILE_PATH + args[0];
        int[] whitelist = new In(path).readAllInts();
        Arrays.sort(whitelist);

        StdOut.println("Original sorted arr is: \n" + Arrays.toString(whitelist));
        int[] res = removeDuplicate(whitelist);
        StdOut.println(Arrays.toString(res));
    }

    public static int[] removeDuplicate(int[] arr) {
        int count = 0;
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] != arr[i]) {
                newArr[count++] = arr[i];
            }
        }
        newArr[count++] = arr[arr.length - 1];

        int[] compactNewArr = new int[count];
        System.arraycopy(newArr, 0, compactNewArr, 0, count);
        return compactNewArr;
    }
}
