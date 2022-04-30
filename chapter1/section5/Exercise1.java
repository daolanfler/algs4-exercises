package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1 {

    static class QuickFind {
        private int count;
        private int[] id;
        private int cost;

        public QuickFind(int N) {
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
            if (rootP == rootQ) return;
            for (int i = 0; i < id.length; i++) {
                if (find(i) == rootP) {
                    id[i] = rootQ;
                    cost++;
                }
            }
            count--;
        }

    }


    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind a = new QuickFind(N);
        StdOut.println("initial array:   " + Arrays.toString(a.id));
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            a.union(p, q);
            StdOut.print(p + "-" + q + " id array is: ");
            StdOut.print(Arrays.toString(a.id));
            StdOut.print(" cost is " + a.cost + "\n");
        }
    }
}

/*
$ java-algs4 chapter1/section5/Exercise1.java <  chapter1/section5/tinyInput.txt
initial array:   [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
9-0 id array is: [0, 1, 2, 3, 4, 5, 6, 7, 8, 0] cost is 13
3-4 id array is: [0, 1, 2, 4, 4, 5, 6, 7, 8, 0] cost is 13
5-8 id array is: [0, 1, 2, 4, 4, 8, 6, 7, 8, 0] cost is 13
7-2 id array is: [0, 1, 2, 4, 4, 8, 6, 2, 8, 0] cost is 13
2-1 id array is: [0, 1, 1, 4, 4, 8, 6, 1, 8, 0] cost is 14
5-7 id array is: [0, 1, 1, 4, 4, 1, 6, 1, 1, 0] cost is 14
0-3 id array is: [4, 1, 1, 4, 4, 1, 6, 1, 1, 4] cost is 14
4-2 id array is: [1, 1, 1, 1, 1, 1, 6, 1, 1, 1] cost is 16
 */
