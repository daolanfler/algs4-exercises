package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise30 {
    public static int gcd(int p, int q) {
        if (p == 0) return q;
        if (q == 0) return p;
        if (p % q == 0) return q;
        return gcd(q, p % q);
    }

    public static boolean[][] primeMatrix(int N) {
        boolean[][] matrix = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                int x = gcd(i, j);
                matrix[i][j] = x == 1;
            }

        return matrix;
    }

    public static void printArr(boolean[][] a, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j])
                    StdOut.printf(" * ");
                else
                    StdOut.printf("   ");
            }
            StdOut.println();
        }

    }

    public static void main(String[] args) {
        boolean[][] m = primeMatrix(17);
        printArr(m, 17);
    }
}
