package chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise32 {
    public static double[] randomArr(int N, double l, double r) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = StdRandom.uniform(l, r);
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 1000;
        double l = 10.3;
        double r = 75.4;
        double[] arr = randomArr(N, l, r);

        int parts = 75;
        double w = (r - l) / parts;
        int[] data = new int[parts];

        for (int i = 0; i < parts; i++) {
            for (double x : arr) {
                if (x >= l + i * w && x < l + (i + 1) * w)
                    data[i]++;
            }
        }
        StdDraw.setYscale(0, 100);
        StdDraw.setXscale(0, 100);

        for (int i = 0; i < parts; i++) {
            double x = l + i * w + w / 2;
            double y = data[i] / 2.0;
            double rh = data[i] / 2.0;
            StdDraw.filledRectangle(x, y, w, rh);
        }
        StdOut.println(Arrays.toString(data));
    }
}
