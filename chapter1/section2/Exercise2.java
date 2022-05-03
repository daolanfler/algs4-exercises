package chapter1.section2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise2 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval1D[] list = new Interval1D[N];
        int index = 0;
        while (!StdIn.isEmpty() && index < N) {
            double a = StdIn.readDouble();
            double b = StdIn.readDouble();
            Interval1D ab = new Interval1D(a, b);
            list[index] = ab;
            index++;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (list[i].intersects(list[j])) {
                    StdOut.println("interval: " + list[i] + " intersects with " + list[j]);
                }
            }
        }
    }
}
/**
 * $ java-algs4 chapter1/section2/Exercise2.java  4
 * 1 4
 * 3 6
 * 7 8
 * 5 7
 * ^Z
 * interval: [1.0, 4.0] intersects with [3.0, 6.0]
 * interval: [3.0, 6.0] intersects with [5.0, 7.0]
 * interval: [7.0, 8.0] intersects with [5.0, 7.0]
 * <p>
 * FANG Qi@Helloween MINGW64 ~/Desktop/exercises (main)
 * $ java-algs4 chapter1/section2/Exercise2.java  6
 * 1 4
 * 3 6
 * 7 8
 * 5 7
 * 6 10
 * 0 100
 * ^Z
 * interval: [1.0, 4.0] intersects with [3.0, 6.0]
 * interval: [1.0, 4.0] intersects with [0.0, 100.0]
 * interval: [3.0, 6.0] intersects with [5.0, 7.0]
 * interval: [3.0, 6.0] intersects with [6.0, 10.0]
 * interval: [3.0, 6.0] intersects with [0.0, 100.0]
 * interval: [7.0, 8.0] intersects with [5.0, 7.0]
 * interval: [7.0, 8.0] intersects with [6.0, 10.0]
 * interval: [7.0, 8.0] intersects with [0.0, 100.0]
 * interval: [5.0, 7.0] intersects with [6.0, 10.0]
 * interval: [5.0, 7.0] intersects with [0.0, 100.0]
 * interval: [6.0, 10.0] intersects with [0.0, 100.0]
 */
