package chapter1.section5;

public class Exercise7 {
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
        // Exercise 1 - quick find
        // Exercise 2 - quick union
    }
}
