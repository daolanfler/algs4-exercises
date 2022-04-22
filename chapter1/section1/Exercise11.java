package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * $ java-algs4 Exercise11.java
 */
public class Exercise11 {
    public static void main(String[] args) {

        boolean[][] a = sourceArr(StdRandom.uniform(15, 66), StdRandom.uniform(12, 30));
        printArr(a);
    }

    public static int getDigit(int n) {
        int digit = 0;
        while (n > 0) {
            digit++;
            n = n / 10;
        }
        return digit;
    }

    public static boolean[][] sourceArr(int m, int n) {
        boolean[][] a = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = StdRandom.bernoulli(0.75) ? true : false;

        return a;
    }

    public static void printArr(boolean[][] a) {
        int row = a.length;
        int col = 0;
        for (int k = 0; k < a.length; k++) {
            col = Math.max(col, a[k].length);
        }
        int digit = getDigit(Math.max(row, col));
        int charLen = digit + 3;
        String formatD = "%-" + charLen + "d";
        String formatS = "%-" + charLen + "s";

        StdOut.print(" ".repeat(charLen));
        for (int m = 0; m < col; m++)
            StdOut.printf(formatD, m + 1);

        for (int i = 0; i < a.length; i++) {
            StdOut.println();
            for (int j = 0; j < a[i].length; j++) {
                if (j == 0)
                    StdOut.printf(formatD, i + 1);
                if (a[i][j])
                    StdOut.printf(formatS, "*");
                else
                    StdOut.printf(formatS, " ");
            }
        }

    }
}

// @formatter:off
// $ java-algs4 Exercise11.java
//      1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26
// 1         *    *    *    *    *    *    *    *    *         *    *    *    *    *    *    *    *    *    *    *         *         *
// 25   *    *         *    *    *    *    *    *    *    *         *    *         *         *    *    *    *         *    *    *    *
// 26   *    *    *    *         *    *         *    *    *    *    *    *    *         *    *    *    *         *    *    *    *    *
// 27   *    *    *    *    *    *    *         *    *    *    *    *    *    *    *    *         *    *    *    *         *         *
// 28   *    *    *    *    *    *         *    *    *    *              *    *    *    *    *         *    *    *    *    *         *
// 29   *    *         *         *    *    *    *    *    *         *    *         *    *         *    *    *         *    *    *    *
// 30   *    *    *    *         *         *         *    *              *    *         *    *    *    *    *    *    *    *    *    *
// 31   *    *    *    *    *    *    *         *    *    *    *    *         *    *    *    *    *    *    *    *         *    *    *
// 32   *    *         *              *    *    *    *         *    *    *    *    *    *         *    *    *    *         *         *
// 33   *         *    *         *    *    *    *    *         *    *    *         *         *         *         *    *    *    *    *
// 34        *    *         *    *    *    *    *    *    *    *    *    *    *    *    *    *         *    *         *    *    *
// 35   *         *    *    *    *    *    *    *    *    *         *    *    *    *         *         *    *    *    *    *
// 36   *    *         *    *    *    *    *    *         *    *              *    *    *              *    *    *    *    *    *    *
// 37   *         *    *    *    *    *         *    *    *    *    *    *    *         *         *    *                   *    *
// 38             *         *    *    *    *         *         *    *         *    *    *    *         *    *              *    *    *
// 39   *    *    *    *    *              *    *    *    *    *    *    *         *    *         *         *    *    *    *         *
// 40   *    *    *         *    *              *    *    *    *    *    *    *    *         *    *    *    *    *    *    *    *    *
// 41   *         *         *         *         *    *    *         *         *         *    *    *         *    *    *    *    *
// 42        *         *    *    *    *                   *    *    *    *    *    *    *    *                        *    *    *    *
// 43   *    *    *         *    *    *    *    *    *    *    *         *    *    *    *    *    *         *         *    *    *    *
// 44        *    *    *    *    *    *    *              *    *    *         *    *    *         *    *    *         *    *    *    *
// 45   *    *    *         *    *    *    *    *    *    *    *              *    *    *    *              *    *    *    *         *
// 46   *              *    *    *    *    *    *         *    *         *    *    *         *    *    *         *    *              *
// 47   *    *    *    *    *    *    *    *    *    *         *         *    *    *         *    *    *    *         *    *         *
// 48   *         *    *    *    *    *              *    *    *         *         *    *              *              *    *    *    *
// 49   *    *    *    *    *    *    *    *         *    *    *         *    *    *    *         *    *    *         *    *    *    *
// @formatter:on
