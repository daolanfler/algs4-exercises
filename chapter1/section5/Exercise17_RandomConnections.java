package chapter1.section5;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Exercise17_RandomConnections {
    public static int count(int N) {
        // using algs4 package's implementation
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        int connectionsGenerated = 0;
        while (uf.count() != 1) {
            int p = StdRandom.uniform(0, N);
            int q = StdRandom.uniform(0, N);
            connectionsGenerated++;
            if (uf.find(p) != uf.find(q)) {
                uf.union(p, q);
            }
        }
        return connectionsGenerated;
    }

    /**
     * $ java-algs4 chapter1/section5/Exercise17_RandomConnections.java 30000
     * 29999
     */
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int count = count(N);
        StdOut.println(count);
    }
}

