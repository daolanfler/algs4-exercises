package Ch_1_1_Basic_Programming_Model;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Practice_1_1_07 {
    public static void main(String[] args) {
        a(9.0);
        b();
        a_draw();
        c();
    }

    /**
     * 牛顿迭代法求平方根
     */
    public static double a(double x) {
        double result = x;
        while (Math.abs(result - x / result) > .001)
            result = (x / result + result) / 2.0;
        StdOut.printf("%.5f\n", result);
        return result;
    }

    public static void a_draw() {
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 12);
        StdDraw.setPenRadius(.001);
        for (double i = 0; i < 100; i += .001) {
            double y = a(i);
            StdDraw.point(i, y);
        }
    }

    /**
     * 0 + 1 + 2 + .... + 999
     */
    public static void b() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }

    /**
     * (lg2(1000) 向下取整 + 1) * 1000
     */
    public static void c() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum++;
        StdOut.println(sum);
    }
}
