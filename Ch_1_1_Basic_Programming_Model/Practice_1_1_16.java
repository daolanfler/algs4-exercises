package Ch_1_1_Basic_Programming_Model;

import edu.princeton.cs.algs4.StdOut;

public class Practice_1_1_16 {
    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
        // 递归调用栈执行顺序
        String a = exR1(6);
        StdOut.println(a);
    }
}

//    $ java-algs4 Practice_1_1_16.java
//        311361142246
//
