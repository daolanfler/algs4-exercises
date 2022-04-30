package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise4 {
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
            while (p != id[p]) {
                p = id[p];
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

    public static void refInput() {
        UF a = new UF(10);
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
            StdOut.print(p + "-" + q + " cost is: " + a.cost + "\n");
            StdOut.print("id array is: ");
            StdOut.print(Arrays.toString(a.id) + "\n");
            StdOut.println("size arr is: " + Arrays.toString(a.size));
            StdOut.println();
        }
        StdOut.println("total components: " + a.count);
    }
}

/* 对照输入
$ java-algs4 chapter1/section5/Exercise4.java <  chapter1/section5/referencInput.txt
initial array:   [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
4-3 cost is: 3
id array is: [0, 1, 2, 4, 4, 5, 6, 7, 8, 9]
size arr is: [1, 1, 1, 1, 2, 1, 1, 1, 1, 1]

3-8 cost is: 5
id array is: [0, 1, 2, 4, 4, 5, 6, 7, 4, 9]
size arr is: [1, 1, 1, 1, 3, 1, 1, 1, 1, 1]

6-5 cost is: 3
id array is: [0, 1, 2, 4, 4, 6, 6, 7, 4, 9]
size arr is: [1, 1, 1, 1, 3, 1, 2, 1, 1, 1]

9-4 cost is: 3
id array is: [0, 1, 2, 4, 4, 6, 6, 7, 4, 4]
size arr is: [1, 1, 1, 1, 4, 1, 2, 1, 1, 1]

2-1 cost is: 3
id array is: [0, 2, 2, 4, 4, 6, 6, 7, 4, 4]
size arr is: [1, 1, 2, 1, 4, 1, 2, 1, 1, 1]

8-9 cost is: 6
id array is: [0, 2, 2, 4, 4, 6, 6, 7, 4, 4]
size arr is: [1, 1, 2, 1, 4, 1, 2, 1, 1, 1]

5-0 cost is: 5
id array is: [6, 2, 2, 4, 4, 6, 6, 7, 4, 4]
size arr is: [1, 1, 2, 1, 4, 1, 3, 1, 1, 1]

7-2 cost is: 3
id array is: [6, 2, 2, 4, 4, 6, 6, 2, 4, 4]
size arr is: [1, 1, 3, 1, 4, 1, 3, 1, 1, 1]

6-1 cost is: 5
id array is: [6, 2, 6, 4, 4, 6, 6, 2, 4, 4]
size arr is: [1, 1, 3, 1, 4, 1, 6, 1, 1, 1]

1-0 cost is: 8
id array is: [6, 2, 6, 4, 4, 6, 6, 2, 4, 4]
size arr is: [1, 1, 3, 1, 4, 1, 6, 1, 1, 1]

6-7 cost is: 6
id array is: [6, 2, 6, 4, 4, 6, 6, 2, 4, 4]
size arr is: [1, 1, 3, 1, 4, 1, 6, 1, 1, 1]

total components: 2

 */

/* 最坏情况下输入
$ java-algs4 chapter1/section5/Exercise4.java <  chapter1/section5/worstInput.txt
initial array:   [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
0-1 cost is: 3
id array is: [0, 0, 2, 3, 4, 5, 6, 7, 8, 9]
size arr is: [2, 1, 1, 1, 1, 1, 1, 1, 1, 1]

2-3 cost is: 3
id array is: [0, 0, 2, 2, 4, 5, 6, 7, 8, 9]
size arr is: [2, 1, 2, 1, 1, 1, 1, 1, 1, 1]

4-5 cost is: 3
id array is: [0, 0, 2, 2, 4, 4, 6, 7, 8, 9]
size arr is: [2, 1, 2, 1, 2, 1, 1, 1, 1, 1]

6-7 cost is: 3
id array is: [0, 0, 2, 2, 4, 4, 6, 6, 8, 9]
size arr is: [2, 1, 2, 1, 2, 1, 2, 1, 1, 1]

0-2 cost is: 3
id array is: [0, 0, 0, 2, 4, 4, 6, 6, 8, 9]
size arr is: [4, 1, 2, 1, 2, 1, 2, 1, 1, 1]

4-6 cost is: 3
id array is: [0, 0, 0, 2, 4, 4, 4, 6, 8, 9]
size arr is: [4, 1, 2, 1, 4, 1, 2, 1, 1, 1]

0-4 cost is: 3
id array is: [0, 0, 0, 2, 0, 4, 4, 6, 8, 9]
size arr is: [8, 1, 2, 1, 4, 1, 2, 1, 1, 1]

total components: 3

 */
