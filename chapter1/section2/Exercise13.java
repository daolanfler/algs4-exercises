package chapter1.section2;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Objects;

public class Exercise13 {
    public static class Transaction implements Comparable<Transaction> {
        private final String who;
        private final Date when;
        private final double amount;

        public Transaction(String who, Date when, double amount) {
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public Transaction(String transaction) {

            String[] arr = transaction.split(",");
            this.who = arr[0];
            this.when = new Date(arr[1]);
            this.amount = Double.parseDouble(arr[2]);
        }

        public String who() {
            return who;
        }

        public Date when() {
            return when;
        }

        public double amount() {
            return amount;
        }

        @Override
        public String toString() {
            return "Transaction amount: " + amount + " by: " + who + " time: " + when;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null) return false;
            if (this.getClass() != that.getClass()) return false;
            Transaction x = (Transaction) that;
            if (!x.who.equals(this.who) ) return false;
            if (!x.when.equals(this.when) ) return false;
            if (x.amount != this.amount) return false;
            return true;
        }

        @Override
        public int compareTo(Transaction that) {
            if (that.amount > this.amount) return -1;
            else if (that.amount < this.amount) return 1;
            return 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(who, when, amount);
        }
    }

    public static void main(String[] args) {
        Transaction a = new Transaction("Bob Dylan,12/31/2000,13.33");
        StdOut.println("a: " + a);
        Transaction b = new Transaction("Bob Dylan", new Date("12/31/2000"), 13.34);
        StdOut.println("b: " + b);
        StdOut.println("a equals to b? " + (a.equals(b)) + " Expected: false");
        
        Transaction[] arr = {b, a};
        Arrays.sort(arr);
        StdOut.println("\nSort [b, a], Expecting [a, b] after sort");
        StdOut.println(Arrays.toString(arr));
        Transaction c = new Transaction("Bob Dylan", new Date("12/31/2000"), 13.34);
        
        StdOut.println("b equals to c? " + (b.equals(c)) + " Expected: true");
        
    }
}

/**
 * a: Transaction amount: 13.33 by: Bob Dylan time: 12/31/2000
 * b: Transaction amount: 13.34 by: Bob Dylan time: 12/31/2000
 * a equals to b? false Expected: false
 *
 * Sort [b, a], Expecting [a, b] after sort
 * [Transaction amount: 13.33 by: Bob Dylan time: 12/31/2000, Transaction amount: 13.34 by: Bob Dylan time: 12/31/2000]
 * b equals to c? true Expected: true
 */
