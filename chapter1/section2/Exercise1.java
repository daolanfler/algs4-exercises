package chapter1.section2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class Exercise1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Point2D[] arr = new Point2D[n];
        for (int i = 0; i < n; i++)
            arr[i] = new Point2D(StdRandom.uniform(0, 100.0), StdRandom.uniform(0, 100.0));

        int indexA = 0;
        int indexB = 0;
        double distance = Double.POSITIVE_INFINITY;

        for (int i = 0; i < n; i++) {
            Point2D a = arr[i];
            for (int j = i +1; j < n; j++) {
                Point2D b = arr[j];
                double d = a.distanceTo(b);
                if (d < distance) {
                    indexA = i;
                    indexB = j;
                    distance = d;
                }
            }
        }
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenColor(Color.blue);
        StdDraw.setPenRadius(.006);
        for (int i = 0; i < n; i++) {
            arr[i].draw();
        }
        StdDraw.setPenColor(Color.red);
        arr[indexA].drawTo(arr[indexB]);
    }

}
