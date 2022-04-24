package chapter1.section1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise31 {
    // java-algs4 chapter1/section1/Exercise31.java 32 0.5
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        StdDraw.setXscale(-60, 60);
        StdDraw.setYscale(-60, 60);
        StdDraw.setPenRadius(.0005);
        Point2D[] arr = new Point2D[N];
        double unit = Math.PI * 2 / N;
        int r = 50;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Point2D(Math.cos(i * unit) * r, Math.sin(i * unit) * r);
            arr[i].draw();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (StdRandom.bernoulli(p)) {
                    arr[i].drawTo(arr[j]);

                }
            }
        }

    }
}
