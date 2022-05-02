package chapter1.section5;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise20_DynamicGrowth {

    public static class DynamicUF {

        private int numberOfSites = 0;
        private int[] id;
        private int[] size;
        private int count = 0; // number of components

        public int find(int p) {
            if (id == null || p >= numberOfSites) {
                throw new IllegalArgumentException("site does not exist");
            }
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }


        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }


        public void union(int p, int q) {
            if (id == null || p >= numberOfSites || q >= numberOfSites) {
                StdOut.println("p: " + p + " q: " + q);
                throw new IllegalArgumentException("wrong parameters ");
            }
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (size[rootP] <= size[rootQ]) {
                id[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                id[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }

        public int newSite() {
            if (id == null) {
                id = new int[1];
                size = new int[1];
            }

            if (numberOfSites == id.length) {
                resizeArray(id.length * 2);
            }

            int newSiteId = numberOfSites;
            size[newSiteId] = 1;
            id[newSiteId] = newSiteId;
            count++;
            numberOfSites++;
            return newSiteId;
        }


        private void resizeArray(int capacity) {
            int[] newId = new int[capacity];
            int[] newSize = new int[capacity];
            for (int i = 0; i < numberOfSites; i++) {
                newId[i] = id[i];
                newSize[i] = size[i];
            }
            id = newId;
            size = newSize;
        }

    }


    public static void main(String[] args) {
        Exercise20_DynamicGrowth.DynamicUF uf = new Exercise20_DynamicGrowth.DynamicUF();
        int N = 10;
        for (int i = 0; i < N; i++) {
            uf.newSite();
        }
        while (uf.count != 1) {
            int p = StdRandom.uniform(0, uf.numberOfSites);
            int q = StdRandom.uniform(0, uf.numberOfSites);
            uf.union(p, q);
            StdOut.println("uniting sites p-q: " + p + " " + q);

        }
        StdOut.println("capacity of id arr: " + uf.id.length);
        // expecting error thrown
        uf.union(10, 9);

    }

}

/**
 * $ java-algs4 chapter1/section5/Exercise20_DynamicGrowth.java
 * uniting sites p-q: 4 0
 * uniting sites p-q: 9 4
 * uniting sites p-q: 8 7
 * uniting sites p-q: 6 2
 * uniting sites p-q: 8 0
 * uniting sites p-q: 8 0
 * uniting sites p-q: 4 1
 * uniting sites p-q: 6 4
 * uniting sites p-q: 7 3
 * uniting sites p-q: 5 1
 * capacity of id arr: 16
 * p: 10 q: 9
 * Exception in thread "main" java.lang.IllegalArgumentException: wrong parameters
 * at chapter1.section5.Exercise20_DynamicGrowth$DynamicUF.union(Exercise20_DynamicGrowth.java:36)
 * at chapter1.section5.Exercise20_DynamicGrowth.main(Exercise20_DynamicGrowth.java:99)
 */

