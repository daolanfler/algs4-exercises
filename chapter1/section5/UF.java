package chapter1.section5;

public interface UF {
    int count();

    int find(int site);

    boolean connected(int p, int q);

    void union(int p, int q);
}
