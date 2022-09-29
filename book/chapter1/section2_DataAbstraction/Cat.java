package book.chapter1.section2_DataAbstraction;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

public class Cat {
    /**
     * algorithms/book/chapter1/ADT on  main [!+?]
     * java -cp ../../../lib/algs4.jar Cat.java in1.txt in2.txt out.txt
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Out out = new Out(args[args.length - 1]);

        for (int i = 0; i < args.length - 1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.print(s);
        }
        out.close();
    }
}
