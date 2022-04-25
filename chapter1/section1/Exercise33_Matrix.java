package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise33_Matrix {

    // scalar dot product
    private static double dot(double a[], double b[]) {
        if (a == null || b == null || a.length != b.length) {
            throw new IllegalArgumentException("a and b must have the same length");
        }
        double res = 0;
        for (int i = 0; i < a.length; i++) {
            res += a[i] * b[i];
        }
        return res;
    }

    // matrix x matrix
    private static double[][] mult(double a[][], double b[][]) {
        if (a == null || b == null || a.length == 0 || b.length == 0 || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }
        int m = a.length;
        int n = b.length;
        int l = b[0].length;
        // (m, n) x (n, l) returns (m, l) matrix
        double[][] res = new double[m][l];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < l; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }

    private static double[][] transpose(double[][] a) {
        if (a == null) {
            throw new IllegalArgumentException();
        }

        double[][] res = new double[a[0].length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[j][i] = a[i][j];
            }
        }

        return res;
    }

    // (m, n) x (n 维列向量) n 维线性空间列向量转换为 m 维空间的列向量
    private static double[] mult(double[][] a, double[] x) {
        if (a == null || x == null || a[0].length != x.length) {
            throw new IllegalArgumentException();
        }

        double[] res = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i] += a[i][j] * x[j];
            }
        }
        return res;
    }

    // (m 维空间行向量) x (m, n) m 维空间行向量转换为 n 维空间行向量
    private static double[] mult(double[] x, double[][] a) {
        if (a == null || x == null || a.length != x.length) {
            throw new IllegalArgumentException();
        }
        double[] res = new double[a[0].length];

        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < x.length; j++)
                res[i] += a[j][i] * x[j];
        }
        return res;
    }

    public static void print(double[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                StdOut.printf("%-10.2f ", a[i][j]);
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        double[] x = {1, 2, 4};
        double[] y = {4, 2, 3.5};
        StdOut.println("Vector scalar dot product: " + dot(x, y));

        double[][] a = {
                {1, 2, 3},
                {5, 3, 4},
                {23, 1, 12}
        };
        double[][] b = {
                {3, 4, 5, 1.3},
                {4, 7, 8, 5.6},
                {1, 3.4, 2.3, 7}
        };
        StdOut.println("\nMatrix x matrix product: ");
        double[][] ab = mult(a, b);
        print(ab);

        StdOut.println("\nTranspose: ");
        StdOut.println("original: ");
        print(b);
        StdOut.println("transposed: ");
        print(transpose(b));

        double[] v = {1, 2, 3, 4};
        StdOut.println("\nMatrix x vector product: ");
        print(b);
        StdOut.println(" multiply " + Arrays.toString(v));
        StdOut.println("is: " + Arrays.toString(mult(b, v)));

        double[][] c = {
                {3, 4},
                {4, 7},
                {1, 3.4},
                {4, 7},
        };
        StdOut.println("\nVector x matrix product: ");
        StdOut.println(Arrays.toString(v) + " multiply ");
        print(c);
        StdOut.println("is: " + Arrays.toString(mult(v, c)));

    }
}


/*
$ java-algs4 chapter1/section1/Exercise33_Matrix.java
Vector scalar dot product: 22.0

Matrix x matrix product:
14.00      28.20      27.90      33.50
31.00      54.60      58.20      51.30
85.00      139.80     150.60     119.50

Transpose:
original:
3.00       4.00       5.00       1.30
4.00       7.00       8.00       5.60
1.00       3.40       2.30       7.00
transposed:
3.00       4.00       1.00
4.00       7.00       3.40
5.00       8.00       2.30
1.30       5.60       7.00

Matrix x vector product:
3.00       4.00       5.00       1.30
4.00       7.00       8.00       5.60
1.00       3.40       2.30       7.00
 multiply [1.0, 2.0, 3.0, 4.0]
is: [31.2, 64.4, 42.7]

Vector x matrix product:
[1.0, 2.0, 3.0, 4.0] multiply
3.00       4.00
4.00       7.00
1.00       3.40
4.00       7.00
is: [30.0, 56.2]

 */
