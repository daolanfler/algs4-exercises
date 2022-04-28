package book.chapter1.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }


    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (qID == pID) return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF quickFindUF = new QuickFindUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (quickFindUF.connected(p, q)) continue;
            quickFindUF.union(p, q);
            StdOut.println(p + " " + q);

        }
        StdOut.println(quickFindUF.count() + " components");
    }

}

// java-algs4 book/chapter1/UnionFind/QuickFindUF.java < ~/Desktop/Algorithms/union-find/tinyUF.txt
