package book.chapter1.section3_QueuesAndStacks;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Dijkstra_Two_Stack_Expression_Evaluation {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        // 对格式的要求比较苛刻，，，， 要括号，不然不会计算
        // 还不如看看 Leetcode 的 Calculator 题目
        // java -cp ./lib/algs4.jar book/chapter1/section3_QueuesAndStacks/Dijkstra_Two_Stack_Expression_Evaluation.java

        // ( ( 1 + 2 ) * 3 ) ctrl + D 

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);

            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            } else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
