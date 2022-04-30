package chapter1.section5;

public class Exercise8 {
    public static void main(String[] args) {
        // if (id[i] == id[p]) id[i] = id[q]
        // 这样遍历到 id[p] 的时候，设置为 id[q] 导致后面的 id[i] 等于原 id[p] 的触点不会被更新
        //       0 1 2 3 4 5
        //       1 1 1 3 1 4
        // 2-3   3 3 3 3 1 4   注意到索引为 4 的触点没有更新
    }
}
