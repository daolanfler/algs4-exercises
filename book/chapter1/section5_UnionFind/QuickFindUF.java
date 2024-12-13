package book.chapter1.section5_UnionFind;

import chapter1.section5.UF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF implements UF {
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
            if (id[i] == pID) id[i] = qID; // 这里我们不关心谁是Q谁是 P
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

/**
 * 如何运行这个代码呢？
 * 首先编译出 class 文件：
 * javac-algs4 book/chapter1/section5_UnionFind/QuickFindUF.java
 * 然后执行下面的：（注意，没有 .java 的后缀！！！！）
 * java-algs4 book/chapter1/section5_UnionFind/QuickFindUF  < chapter1/section5/tinyInput.txt
 * 但是上面的方法会在 QuickFindUF.java 的目录生成一个 QuickFindUF.class 的文件。
 *
 * 当我们使用 IDEA 的时候，编译产物放到了 out 目录，可以这样
 * java -cp "./out/production/algs4-exercises;./lib/algs4.jar" book/chapter1/section5_UnionFind/QuickFindUF < chapter1/section5/tinyInput.txt
 * 使用 java-algs4 也是一样的
 *
 * 很可惜  < chapeter1/section5/tinyInput.txt 作为 args 在 vscode launch.json 的 run & debug configurations 里面并不起作用，所以这里还是只能手动运行
 * https://stackoverflow.com/questions/28920762/intellij-run-config-input-file
 */
