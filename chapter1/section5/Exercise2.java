package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise2 {
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
            id[rootP] = rootQ;
            cost++;
            count--;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF a = new UF(N);
        StdOut.println("initial array:   " + Arrays.toString(a.id));
        int total = 0;
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            a.union(p, q);
            total += a.cost;
            StdOut.print(p + "-" + q + " id array is: ");
            StdOut.print(Arrays.toString(a.id));
            StdOut.print(" cost is: " + a.cost);
            StdOut.print(" total cost is: " + total + "\n");
        }
        StdOut.println("total components: " + a.count);
    }
}

/* output:
$ java-algs4 chapter1/section5/Exercise2.java <  chapter1/section5/tinyInput.txt
initial array:   [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
9-0 id array is: [0, 1, 2, 3, 4, 5, 6, 7, 8, 0] cost is: 3 total cost is: 3
3-4 id array is: [0, 1, 2, 4, 4, 5, 6, 7, 8, 0] cost is: 3 total cost is: 6
5-8 id array is: [0, 1, 2, 4, 4, 8, 6, 7, 8, 0] cost is: 3 total cost is: 9
7-2 id array is: [0, 1, 2, 4, 4, 8, 6, 2, 8, 0] cost is: 3 total cost is: 12
2-1 id array is: [0, 1, 1, 4, 4, 8, 6, 2, 8, 0] cost is: 3 total cost is: 15
5-7 id array is: [0, 1, 1, 4, 4, 8, 6, 2, 1, 0] cost is: 9 total cost is: 24
0-3 id array is: [4, 1, 1, 4, 4, 8, 6, 2, 1, 0] cost is: 5 total cost is: 29
4-2 id array is: [4, 1, 1, 4, 1, 8, 6, 2, 1, 0] cost is: 5 total cost is: 34
 */
