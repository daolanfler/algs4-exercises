package chapter1.section1;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise35 {
    static private int SIDES = 6;

    public static double[] realProbability() {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;
        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;
        return dist;
    }

    public static boolean allPrecise(double[] testP, double[] realP) {
        int SIDES = 6;
        for (int i = 2; i <= 2 * SIDES; i++) {
            int a = (int)Math.floor(testP[i] * 1000);
            int b = (int)Math.floor(realP[i] * 1000);
            if (a != b)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        double[] realP = realProbability();
        double[] testP = new double[2 * SIDES + 1];
        int N = 1;
        while (!allPrecise(testP, realP)) {
            for (int i = 2; i < 2 * SIDES; i++)
                testP[i] = 0.0;
            for (int i = 0; i <= N; i++) {
                int testA = StdRandom.uniform(1, 7);
                int testB = StdRandom.uniform(1, 7);
                testP[testA + testB] += 1.0;
            }
            for (int k = 2; k <= 2 * SIDES; k++)
                testP[k] /= N;
            N++;
        }
        StdOut.println("Need " + N + " times to reach 3 decimal precision");
        StdOut.println(Arrays.toString(testP));
        StdOut.println(Arrays.toString(realP));
    }
}
