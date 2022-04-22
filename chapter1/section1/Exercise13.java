package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise13 {

    public static void transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] matrixT = new int[n][m];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrixT[j][i] = matrix[i][j];

        StdOut.println("Transposed matrix is: ");
        print(matrixT);
    }

    private static void print(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                StdOut.printf("%-4d", matrix[i][j]);
            StdOut.println();
        }
    }

    public static int[][] getMatrix(int m, int n) {

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = StdRandom.uniform(0, 100);

        return matrix;
    }

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        int[][] matrix = getMatrix(m, n);
        StdOut.println("Original matrix is: ");
        print(matrix);
        StdOut.println();

        transpose(matrix);
    }

}

// $ java-algs4 Exercise13.java  3 4
// Original matrix is:
// 17  3   85  44
// 48  43  93  30
// 96  60  64  56

// Transposed matrix is:
// 17  48  96
// 3   43  60
// 85  93  64
// 44  30  56
