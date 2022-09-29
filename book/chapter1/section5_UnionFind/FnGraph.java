package book.chapter1.section5_UnionFind;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FnGraph {

    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 1000);
        StdDraw.setPenRadius(.0005);

        StdDraw.setXscale(-0.5, 0);
        StdDraw.setYscale(-2.0, 0);

        long N = 450000;
        for (int i = 0; i < N; i += 100) {
            draw(-i * 0.000001);
        }
    }

    public static void draw(double x) {
        double y = 1.44e-6 * (Math.exp((96485 * 2 * 0.5 * x) / (8.314 * 343.15)) - Math.exp((-(1 - 0.5) * 2 * 96485 * x) / (8.314 * 343.15)));
        StdOut.println("x: " + x + " y: " + y);
        if (y <= -2.0 && y > -5.0) {
            StdOut.println(" ============================ x: " + x + " y: " + y);
        }
        StdDraw.point(x, y);

    }

}

