package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise14 {
    static class UF {
        private int count;
        private int cost;
        private int[] id;
        private int[] height; // array of tree's height
        private int maxHeight;

        public UF(int N) {
            id = new int[N];
            height = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
                count++;
                height[i] = 0;
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int find(int p) {
            while (p != id[p]) {
                cost += 2;
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
            if (height[rootP] < height[rootQ]) {
                id[rootP] = rootQ;
            } else if (height[rootP] == height[rootQ]) {
                id[rootQ] = rootP;
                height[rootP]++;
                if (height[rootP] > maxHeight) {
                    maxHeight = height[rootP];
                }
            } else {
                id[rootQ] = rootP;
            }
            cost++;
            count--;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF a = new UF(N);
        int total = 0;
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            a.union(p, q);
            total += a.cost;
        }
        StdOut.println("lgN is: " + (Math.log(N) / Math.log(2)));
        StdOut.println("max height is: " + a.maxHeight);
    }
}
/**
 * $ java-algs4 chapter1/section5/Exercise14.java < chapter1/section5/tinyInput.txt
 * lgN is: 3.3219280948873626
 * max height is: 3
 * <p>
 * $ java-algs4 chapter1/section5/Exercise14.java < ~/Desktop/Algorithms/union-find/mediumUF.txt
 * lgN is: 9.287712379549449
 * max height is: 5
 */
