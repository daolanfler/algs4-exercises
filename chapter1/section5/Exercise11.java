package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise11 {
    static class WeightedQuickFind {
        int[] id;
        int[] size;
        int cost;
        int count;

        public WeightedQuickFind(int N) {
            id = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
                size[i] = 1;
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
            int rootToUpdate = rootP;
            int rootToBe = rootQ;
            // 加权 quick-find，更新 size 较小的触点的 root
            if (size[rootQ] < size[rootP]) {
                rootToUpdate = rootQ;
                rootToBe = rootP;

            }
            for (int i = 0; i < id.length; i++) {
                if (find(i) == rootToUpdate) {
                    id[i] = rootToBe;
                    cost++;
                    size[rootToBe]++;
                }
            }
            count--;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickFind a = new WeightedQuickFind(N);
//        StdOut.println("initial array:   " + Arrays.toString(a.id));
        int total = 0;
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            a.union(p, q);
            total += a.cost;
//            StdOut.print(p + "-" + q + " id array is: ");
//            StdOut.print(Arrays.toString(a.id));
//            StdOut.print(" cost is: " + a.cost);
        }
        StdOut.print(" total cost is: " + total + "\n");
        StdOut.println("total components: " + a.count);
    }
}

/**
 * java-algs4 chapter1/section5/Exercise11.java <  ~/Desktop/Algorithms/union-find/mediumUF.txt
 * total cost is: 392106
 * total components: 3
 * 对比 Exercise1 413867 有一定的优化，加权使得对数组赋值的操作减少
 */
