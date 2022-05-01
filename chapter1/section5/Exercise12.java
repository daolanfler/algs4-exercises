package chapter1.section5;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise12 {
    // 路径压缩的 quick-union
    static class UF {
        private int count;
        private int[] id;
        private int cost;

        public UF(int N) {
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
            int startP = p;
            while (p != id[p]) {
                cost += 2;
                p = id[p];
            }
            // path compression
            while (startP != p) {
                int temp = id[startP];
                id[startP] = p;
                startP = temp;
                cost += 2;
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

    public static void main(String[] args) {
        int N = 10;
        UF a = new UF(N);
        StdOut.println("initial array:   " + Arrays.toString(a.id));
        int total = 0;
        // 给出一条输入使得该方法能产生一条长度为 4 的路径
        int[][] operations = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
        };
        for (int[] pair : operations) {
            int p = pair[0];
            int q = pair[1];
            a.union(p, q);
            total += a.cost;
            StdOut.print(p + "-" + q + " id array is: ");
            StdOut.print(Arrays.toString(a.id));
            StdOut.print(" cost is: " + a.cost + "\n");
        }
        StdOut.print(" total cost is: " + total + "\n");
        StdOut.println("total components: " + a.count);
    }
}
/**
 * $ java-algs4 chapter1/section5/Exercise12.java
 * initial array:   [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 * 0-1 id array is: [1, 1, 2, 3, 4, 5, 6, 7, 8, 9] cost is: 3
 * 1-2 id array is: [1, 2, 2, 3, 4, 5, 6, 7, 8, 9] cost is: 3
 * 2-3 id array is: [1, 2, 3, 3, 4, 5, 6, 7, 8, 9] cost is: 3
 * 3-4 id array is: [1, 2, 3, 4, 4, 5, 6, 7, 8, 9] cost is: 3
 * total cost is: 12
 * total components: 6
 * <p>
 * 0-1-2-3-4 即为长度为 4 的路径
 */
