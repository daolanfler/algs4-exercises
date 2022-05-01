package chapter1.section5;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class Exercise16 {

    static class QuickFindUF {
        private int count; // count of components
        private int[] id;
        private int cost;

        public QuickFindUF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
                count++;
            }
        }

        public boolean connected(int p, int q) {
            return id[p] == id[q];
        }

        public int find(int p) {
            cost++;
            return id[p];
        }

        public void union(int p, int q) {
            cost = 0;
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            for (int i = 0; i < id.length; i++) {
                if (find(i) == rootP) {
                    id[i] = rootQ;
                    cost++;
                }
            }
            count--;
        }

    }

    static class QuickUnionUF {
        private int count;
        private int[] id;
        private int cost;

        public QuickUnionUF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
                count++;
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int find(int p) {
            while (p != id[p]) {
                // 这里算一次操作才能和书上的图吻合
                cost += 1;
                p = id[p];
            }
            cost++;
            return p;
        }

        public void union(int p, int q) {
            cost = 0;
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            id[rootP] = rootQ;
            cost++;
            count--;
        }
    }

    static class WeightedQuickUnionUF {
        private int count;
        private int cost;
        private int[] id;
        private int[] size;

        public WeightedQuickUnionUF(int N) {
            id = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
                count++;
                size[i] = 1;
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int find(int p) {
            while (p != id[p]) {
                // 这里算一次才能符合书上的图
                cost += 1;
                p = id[p];
            }
            cost++;
            return p;
        }

        public void union(int p, int q) {
            cost = 0;
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            if (size[rootP] < size[rootQ]) {
                id[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                id[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            // size 和id 的都算
            cost += 4;
            count--;
        }
    }

    public static void main(String[] args) {
        // Exercise 1 - quick find
        // Exercise 2 - quick union
        // 一次只能画一个
        drawQuickFind();
//        drawQuickUnion();
//        drawWeightQuickUnion();
    }

    // $ java-algs4 chapter1/section5/Exercise16.java < ~/Desktop/Algorithms/union-find/mediumUF.txt
    //459.8522222222222
    public static void drawQuickFind() {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        double totalCost = 0.0;
        StdDraw.setXscale(0, 900);
        StdDraw.setYscale(0, 1300);
        StdDraw.setPenRadius(.003);
        int i = 0;
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            i++;
            uf.union(p, q);
            totalCost += uf.cost;
            StdDraw.setPenColor(Color.gray);
            StdDraw.point(i, uf.cost);
            StdDraw.setPenColor(Color.red);
            StdDraw.point(i, totalCost / i);
        }
        StdOut.println(totalCost / i);

    }

    // $ java-algs4 chapter1/section5/Exercise16.java < ~/Desktop/Algorithms/union-find/mediumUF.txt
    // 20.136666666666667
    public static void drawQuickUnion() {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        double totalCost = 0.0;
        StdDraw.setCanvasSize(900, 100);
        StdDraw.setXscale(0, 900);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(.004);
        int i = 0;
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            i++;
            uf.union(p, q);
            totalCost += uf.cost;
            StdDraw.setPenColor(Color.gray);
            StdDraw.point(i, uf.cost);
            StdDraw.setPenColor(Color.red);
            StdDraw.point(i, totalCost / i);
        }
        StdOut.println(totalCost / i);
    }

    // $ java-algs4 chapter1/section5/Exercise16.java < ~/Desktop/Algorithms/union-find/mediumUF.txt
    //6.963333333333333
    public static void drawWeightQuickUnion() {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        double totalCost = 0.0;
        StdDraw.setCanvasSize(900, 100);
        StdDraw.setXscale(0, 900);
        StdDraw.setYscale(0, 40);
        StdDraw.setPenRadius(.004);
        int i = 0;
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            i++;
            uf.union(p, q);
            totalCost += uf.cost;
            StdDraw.setPenColor(Color.gray);
            StdDraw.point(i, uf.cost);
            StdDraw.setPenColor(Color.red);
            StdDraw.point(i, totalCost / i);
        }
        StdOut.println(totalCost / i);

    }
}
