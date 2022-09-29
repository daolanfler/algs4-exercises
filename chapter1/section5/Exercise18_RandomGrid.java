package chapter1.section5;

import chapter1.section3.Exercise34_RandomBag;
import edu.princeton.cs.algs4.StdOut;

public class Exercise18_RandomGrid {
    public static class Connection {
        public int p;
        public int q;

        public Connection(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }

    public Connection[] generate(int N) {
        Exercise34_RandomBag<Connection> bag = new Exercise34_RandomBag<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    bag.add(new Connection(i, j));
                }
            }
        }
        int index = 0;
        Connection[] connections = new Connection[bag.size()];
        for (Connection c : bag) {
            connections[index] = c;
            index++;
        }
        return connections;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        Connection[] connections = new Exercise18_RandomGrid().generate(N);
        StdOut.println("connections: ");
        for (Connection c : connections) {
            StdOut.println(c.p + " - " + c.q);
        }

    }
}

/**
 * $ java-algs4 -cp ./lib/algs4.jar\;out/production/exercises/ chapter1/section5/Exercise18 4
 * connections:
 * 3 - 0
 * 0 - 2
 * 0 - 3
 * 3 - 1
 * 0 - 1
 * 1 - 2
 * 1 - 3
 * 2 - 1
 * 2 - 3
 * 3 - 2
 * 2 - 0
 * 1 - 0
 */
