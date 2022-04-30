package chapter1.section5;

import edu.princeton.cs.algs4.StdOut;

public class Exercise6 {
    public static void main(String[] args) {

        // weighted quick-union
        // 假设耗时的操作需要执行 5 次指令，只考虑 union 操作中 find 寻找根节点的操作
        // 2 * ( 10^6 * lg(10^9)) * 5 / (10^9 * 24 * 60 * 60) ~= 0.0000034 天
        double second = (2 * 1e6 * (Math.log(1e9) / Math.log(2)) * 5) / 1e9;
        double day = second / (24 * 60 * 60);
        StdOut.println(second + " seconds" + " " + day + " day");
//        StdOut.print(Math.log(4) / Math.log(2));
    }
}
/*
$ java-algs4 chapter1/section5/Exercise6.java
0.29897352853986264 seconds 3.4603417655076695E-6 day
 */
