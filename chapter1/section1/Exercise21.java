package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise21 {
    public static void main(String[] args) {
        StdOut.printf("%-20s%8s%8s%8s\n", "Name", "Value1", "Value2", "Result");
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();

            formatLine(line);
        }
    }

    public static void formatLine(String line) {
        String[] arr = line.split(" ");
        StdOut.printf("%-20s", arr[0]);
        StdOut.printf("%8s", arr[1]);
        StdOut.printf("%8s", arr[2]);

        double value1 = Double.parseDouble(arr[1]);
        double value2 = Double.parseDouble(arr[2]);

        double res = value1 / value2;
        StdOut.printf("%8.3f\n", res);
    }
}
//$ java-algs4 Exercise21.java < Exercise21.txt
//    Name                  Value1  Value2  Result
//    funkey                    40      50   0.800
//    qifang                    32      50   0.640
//    daolanfler                44      50   0.880

