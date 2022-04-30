package chapter1.section5;


import edu.princeton.cs.algs4.StdOut;

public class Exercise5 {
    public static void main(String[] args) {
        // M * N
        // quick find 算法，每一次 union 都会遍历所有触点，循环 10^9 次，执行 10^10 次指令
        // 10^10 * 10^6 / 10^9 = 10^7 秒 = 10^7/(24*60*60) = 115.7 天
        double day = (1e6 * 1e9 * 10) / (1e9 * 24 * 60 * 60);
        StdOut.print(day + " days");
    }
}
/*
$ java-algs4 chapter1/section5/Exercise5.java
115.74074074074075 days
 */
