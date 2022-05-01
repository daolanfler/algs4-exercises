package chapter1.section5;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise13 {
    // 使用路径压缩的加权 quick-union (weighted quick-union with path compression)
    static class UF {
        private int count;
        private int cost;
        private int[] id;
        private int[] size;

        public UF(int N) {
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
            if (size[rootP] < size[rootQ]) {
                id[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                id[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            cost++;
            count--;
        }
    }

    public static void main(String[] args) {
        // 最大的高度也只有 lgN ，所以触点个数至少为 16个
        int N = 16;
        UF a = new UF(N);
        StdOut.println("   initial array:   " + Arrays.toString(a.id));
        int total = 0;
        // 给出一条输入使得该方法能产生一条长度为 4 的路径
        int[][] operations = {
                {0, 1},
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {10, 11},
                {12, 13},
                {14, 15},
                {0, 2},
                {4, 6},
                {8, 10},
                {12, 14},
                {0, 4},
                {8, 12},
                {0, 8}
        };
        for (int[] pair : operations) {
            int p = pair[0];
            int q = pair[1];
            a.union(p, q);
            total += a.cost;
            String str = p + "-" + q;
            StdOut.print(str + " ".repeat(6 - str.length()) + " id array is: ");
            StdOut.print(Arrays.toString(a.id));
            StdOut.print(" cost is: " + a.cost + "\n");
        }
        StdOut.print(" total cost is: " + total + "\n");
        StdOut.println("total components: " + a.count);
    }
}
/**
 * $ java-algs4 chapter1/section5/Exercise13.java
 * initial array:   [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
 * 0-1    id array is: [0, 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15] cost is: 3
 * 2-3    id array is: [0, 0, 2, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15] cost is: 3
 * 4-5    id array is: [0, 0, 2, 2, 4, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15] cost is: 3
 * 6-7    id array is: [0, 0, 2, 2, 4, 4, 6, 6, 8, 9, 10, 11, 12, 13, 14, 15] cost is: 3
 * 8-9    id array is: [0, 0, 2, 2, 4, 4, 6, 6, 8, 8, 10, 11, 12, 13, 14, 15] cost is: 3
 * 10-11  id array is: [0, 0, 2, 2, 4, 4, 6, 6, 8, 8, 10, 10, 12, 13, 14, 15] cost is: 3
 * 12-13  id array is: [0, 0, 2, 2, 4, 4, 6, 6, 8, 8, 10, 10, 12, 12, 14, 15] cost is: 3
 * 14-15  id array is: [0, 0, 2, 2, 4, 4, 6, 6, 8, 8, 10, 10, 12, 12, 14, 14] cost is: 3
 * 0-2    id array is: [0, 0, 0, 2, 4, 4, 6, 6, 8, 8, 10, 10, 12, 12, 14, 14] cost is: 3
 * 4-6    id array is: [0, 0, 0, 2, 4, 4, 4, 6, 8, 8, 10, 10, 12, 12, 14, 14] cost is: 3
 * 8-10   id array is: [0, 0, 0, 2, 4, 4, 4, 6, 8, 8, 8, 10, 12, 12, 14, 14] cost is: 3
 * 12-14  id array is: [0, 0, 0, 2, 4, 4, 4, 6, 8, 8, 8, 10, 12, 12, 12, 14] cost is: 3
 * 0-4    id array is: [0, 0, 0, 2, 0, 4, 4, 6, 8, 8, 8, 10, 12, 12, 12, 14] cost is: 3
 * 8-12   id array is: [0, 0, 0, 2, 0, 4, 4, 6, 8, 8, 8, 10, 8, 12, 12, 14] cost is: 3
 * 0-8    id array is: [0, 0, 0, 2, 0, 4, 4, 6, 0, 8, 8, 10, 8, 12, 12, 14] cost is: 3
 * total cost is: 45
 * total components: 1
 * <p>
 * 最长路径为 0-8-12-14-15
 */
