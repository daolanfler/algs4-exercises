package chapter1.section5;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Exercise17_ErdosRenyi {
    public static int count(int N) {
        // using algs4 package's implementation
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        int unionTimes = 0;
        while (uf.count() != 1) {
            int p = StdRandom.uniform(0, N);
            int q = StdRandom.uniform(0, N);
            uf.union(p, q);
            unionTimes++;
        }
        return unionTimes;
    }

    /**
     * $ java-algs4 chapter1/section5/Exercise17_ErdosRenyi.java 30000
     * 149821
     */
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int count = count(N);
        StdOut.println(count);
    }
}

