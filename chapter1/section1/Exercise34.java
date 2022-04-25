package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise34 {
    static private double min = Double.POSITIVE_INFINITY;
    static private double max = Double.NEGATIVE_INFINITY;

    // 只需要使用固定数量的变量即可
    public static void minMax(double N) {
        if (N < min) min = N;
        if (N > max) max = N;
        StdOut.println("Value: " + N + " Min: " + min + " Max: " + max);
    }

    public static void test1() {
        // 模拟标准输入
        for (int i = 0; i < 10; i++) {
            minMax(StdRandom.uniform(100));
        }
    }

    // 需要保存输入值到数组
    public static void getMidian(double[] arr) {

        double[] copy = new double[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        Arrays.sort(copy);
        if (copy.length % 2 == 0) {
            StdOut.println("Median of " + Arrays.toString(copy) + "is : " + (copy[copy.length / 2] + copy[copy.length / 2 - 1]) / 2);
        } else {
            StdOut.println("Median of " + Arrays.toString(copy) + "is : " + copy[copy.length / 2]);
        }
    }

    public static void test2() {
        double[] arr = new double[12];
        for (int i = 0; i < arr.length; i++)
            arr[i] = StdRandom.uniform(100);
        getMidian(arr);
    }

    private static int k = 4;
    private static double[] kArr = new double[k];
    private static int fillIndex = k;

    public static double max(double[] arr) {
        double res = 0;
        for (double x : arr)
            if (x > res) res = x;
        return res;
    }

    // 第 k 个最小的数，用固定 k 大小的数组即可
    public static void getKthMin(double n) {
        double max = 0.0;
        int maxIndex = 0;
        if (--fillIndex >= 0) {
            // kArr 没有填满
            kArr[fillIndex] = n;
            max = max(kArr);
        } else {
            max = kArr[0];
            maxIndex = 0;
            for (int i = 0; i < kArr.length; i++) {
                if (kArr[i] > max) {
                    max = kArr[i];
                    maxIndex = i;
                }
            }
            if (n < max) {
                kArr[maxIndex] = n; // 踢出当前的第 k 小的数
            }
            max = max(kArr);
        }
        StdOut.println(k + "th min number is: " + max);

    }

    public static void test3() {
        for (int i = 0; i < 14; i++) {
            double x = StdRandom.uniform(0, 100);
            StdOut.println(x);
            getKthMin(x);

        }
    }

    private static double squareSum = 0;

    // 可以使用固定数量的变量
    public static double sumOfSquare(double x) {
        squareSum += x * x;
        StdOut.println("Value: " + x + " square sum is: " + squareSum);
        return squareSum;

    }

    public static void test4() {
        // 模拟标准输入
        for (int i = 0; i < 10; i++) {
            sumOfSquare(StdRandom.uniform(100));
        }
    }

    static private int count = 0;
    static private double sum = 0;

    // 可以使用固定数量的变量
    public static double getMean(double N) {
        count++;
        sum += N;
        StdOut.println("Value: " + N + " average is: " + sum / count);
        return sum / count;
    }

    public static void test5() {
        // 模拟标准输入
        for (int i = 0; i < 10; i++) {
            getMean(StdRandom.uniform(100));
        }
    }

    // 需要保存标准输入中所有的值
    public static double getAboveAvgPercent(double[] arr) {
        double sum = 0.0;
        for (double x : arr)
            sum += x;
        double avg = sum / arr.length;
        int count = 0;
        for (double x : arr)
            if (x > avg) count++;
        StdOut.println("Above average percentage is: " + (count * 1.0 / arr.length) * 100 + "%");
        return count * 1.0 / arr.length;
    }

    public static void test6() {
        double[] arr = new double[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniform(100);
        }
        getAboveAvgPercent(arr);
    }

    // 需要保存标准输入中所有的值
    public static void printAscending(double[] arr) {
        Arrays.sort(arr);
        StdOut.println("Ascending order print: " + Arrays.toString(arr));
    }

    public static void test7() {
        double[] arr = new double[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniform(100);
        }
        printAscending(arr);

    }

    // 需要保存标准输入中所有的值
    public static void printRandomOrder(int[] arr) {
        StdOut.print("random print: ");
        boolean[] printed = new boolean[arr.length];
        int index = StdRandom.uniform(arr.length);
        int len = arr.length;
        while (len-- > 0) {
            while (printed[index]) {
                index = StdRandom.uniform(0, arr.length);
            }
            StdOut.print(arr[index] + " ");
            printed[index] = true;
        }
        StdOut.println();
    }

    public static void test8() {
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++)
            arr[i] = StdRandom.uniform(0, 100);
        StdOut.println("Original array: " + Arrays.toString(arr));
        printRandomOrder(arr);
    }

    public static void main(String[] args) {
        test1();
        StdOut.println("\n=========================");
        test2();
        StdOut.println("\n=========================");
        test3();
        StdOut.println("\n=========================");
        test4();
        StdOut.println("\n=========================");
        test5();
        StdOut.println("\n=========================");
        test6();
        StdOut.println("\n=========================");
        test7();
        StdOut.println("\n=========================");
        test8();

    }
}
