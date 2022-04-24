package chapter1.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import utils.Constants;

import java.util.Arrays;

public class Exercise23 {

    public static int binarySearch(int key, int[] arr) {
        return rank(key, 0, arr.length - 1, arr, 0);
    }

    public static int rank(int key, int lo, int hi, int[] a, int level) {
//        StdOut.println("  ".repeat(level) + "low: " + lo + " " + "high: " + hi);
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if (a[mid] > key) return rank(key, lo, mid - 1, a, ++level);
        else if (a[mid] < key) return rank(key, mid + 1, hi, a, ++level);
        else return mid;
    }

    public static void main(String[] args) {
        // args[0] 是测试数据存放的路径 relative to Constants.FILE_PATH
        String path = Constants.FILE_PATH + args[0];
        char op = args[1].charAt(0);
        if (op != '+' && op != '-') {
            throw new UnsupportedOperationException("operation must be + or -");
        }
        int[] whitelist = new In(path).readAllInts();
        Arrays.sort(whitelist);
        boolean isWhitelistMode = args[1].equals("+");
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            // 如果需要使用 Exercise22 中的 binarySearch 则需要先编译它
            boolean isInList = binarySearch(key, whitelist) > 0;
            if (isWhitelistMode) {
                if (!isInList) StdOut.println("Number not in whitelist: " + key);
            } else {
                if (isInList) StdOut.println("Number in blacklist: " + key);
            }
        }
    }
}


//    git bash 命令行中拼接多个路径到一个参数很奇怪 `\;` 但是 PATH 又可以用 `:`
//    https://stackoverflow.com/questions/46066210/failed-to-run-a-java-app-with-git-bash
//    $ java -classpath ./lib/algs4.jar\;out/production/exercises/  chapter1/section1/Exercise23.java  hello/tinyW.txt +
//        12
//        23
//        22
//        Number not in whitelist: 22
//        44
//        Number not in whitelist: 44
