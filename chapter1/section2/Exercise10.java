package chapter1.section2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise10 {
    public static class VisualCounter {
        private int count = 0;
        private final int maxCountAbs;
        private int trials = 0;
        private final int maxTrials; // max 操作次数

        public VisualCounter(int trials, int max) {
            maxTrials = trials;
            maxCountAbs = max;
            StdDraw.setXscale(0, trials);
            StdDraw.setYscale(-max, max);
            StdDraw.setPenRadius(0.005);
        }

        public void increase() {
            count++;
            trials++;
            if (exceeds()) {
                throw new IllegalCallerException("Either max operation count exceeds or count abs exceeds");
            }
            StdDraw.point(trials, count);
        }

        public void decrease() {
            count--;
            trials++;
            if (exceeds()) {
                throw new IllegalCallerException("Either max operation count exceeds or count abs exceeds");
            }
            StdDraw.point(trials, count);
        }

        private boolean exceeds() {
            return Math.abs(count) > maxCountAbs || trials > maxTrials;
        }

        public static void main(String[] args) {
            VisualCounter counter = new VisualCounter(10, 5);
            for (int i = 0; i < 10; i++) {
                if (StdRandom.bernoulli(0.2)) {
                    counter.increase();
                } else {
                    counter.decrease();
                }
            }

        }

    }

    public static void main(String[] args) {
        VisualCounter.main(args);
    }
}
