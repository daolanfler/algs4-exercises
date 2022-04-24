package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise27 {
    private static long count = 0;

    public static double binomial(int N, int k, double p) {
        count++;
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static void testBinomial() {
        double res = binomial(100, 50, 0.25);
        StdOut.printf("Recursive binomial count: %d, result is: %.24f", count, res);
        count = 0;
    }

    public static void testBinomial2() {
        double p = 0.25;
        for (int N = 0; N < 11; N++) {
            for (int k = 0; k <= N; k++) {
                double res = binomial(N, k, p);
                StdOut.printf("in %d trials happen %s times, chances is %.5f \n", N, k, res);
                StdOut.println("count: " + count);
                StdOut.println("================\n");
                count = 0;
            }
        }
    }

    public static double arrBinomial(double[][] arr, int N, int k, double p) {
        count++;
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        if (arr[N][k] == -1) {
            arr[N][k] = (1.0 - p) * arrBinomial(arr, N - 1, k, p) + p * arrBinomial(arr, N - 1, k - 1, p);
        }
        return arr[N][k];
    }

    public static void testArrBinomial() {
        int N = 100, k = 50;
        double p = 0.25;
        double[][] arr = new double[N + 1][k + 1];
        for (int i = 0; i < N + 1; i++)
            for (int j = 0; j < k + 1; j++)
                arr[i][j] = -1;

        double res = arrBinomial(arr, N, k, p);
        StdOut.printf("Optimized recursive arrBinomial count: %d, result is %.24f \n", count, res);

    }

    public static double forBinomial(int N, int k, double p) {
        double[][] arr = new double[N + 1][k + 1];
        arr[0][0] = 1;
        for (int i = 1; i < N + 1; i++) {
            count++;
            arr[i][0] = (1.0 - p) * arr[i - 1][0];
        }

        for (int i = 1; i < k + 1; i++) {
            arr[0][k] = 0.0;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                count++;
                arr[i][j] = (1.0 - p) * arr[i - 1][j] + p * arr[i - 1][j - 1];
            }
        }

        return arr[N][k];
    }

    public static void testForBinomial() {
        double res = forBinomial(100, 50, 0.25);
        StdOut.printf("Optimized for loop binomial count is: %d, the result is: %.24f", count, res);
    }

    public static void main(String[] args) {
        testBinomial2();
        // k = 100 次数为, Math.pow(2, 102) - 3, k = 50 约为这个一半
//        double res = binomial(100, 50, 0.25);
        testArrBinomial();
        count = 0;

        testForBinomial();
    }
}
