package chapter1.section2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;

public class Exercise3 {
    private static HashMap<Interval2D, Interval1D[]> intervalMap = new HashMap<>();

    public static Interval1D getRandomInterval1D(double min, double max) {
        double a = StdRandom.uniform(min, max);
        double b = StdRandom.uniform(min, max);

        return new Interval1D(Math.min(a, b), Math.max(a, b));
    }

    public static boolean isContained(Interval2D a, Interval2D b) {
        Interval1D xA = intervalMap.get(a)[0];
        Interval1D yA = intervalMap.get(a)[1];

        Interval1D xB = intervalMap.get(b)[0];
        Interval1D yB = intervalMap.get(b)[1];

        return xB.max() > xA.max() && xB.min() < xA.min() && yB.max() > yA.max() && yB.min() < yA.min() ||
                xA.max() > xB.max() && xA.min() < xB.min() && yA.max() > yB.max() && yA.min() < yB.min();
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        Interval2D[] list = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            Interval1D x = getRandomInterval1D(min, max);
            Interval1D y = getRandomInterval1D(min, max);
            Interval2D interval = new Interval2D(x, y);
            interval.draw();
            list[i] = interval;
            intervalMap.put(interval, new Interval1D[]{x, y});
        }

        int intersections = 0;
        int contains = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (list[i].intersects(list[j])) intersections++;
                if (isContained(list[i], list[j])) contains++;
            }
        }

        StdOut.println("intersection count: " + intersections + " contain count: " + contains);
    }

}
