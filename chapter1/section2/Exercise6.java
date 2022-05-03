package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise6 {
    static public boolean isCircularRotation(String s, String t) {
        return s.length() == t.length() && (s + s).indexOf(t) >= 0;
    }

    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";
        StdOut.println(isCircularRotation(s, t));
    }

}
