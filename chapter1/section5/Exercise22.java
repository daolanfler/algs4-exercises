package chapter1.section5;

import book.chapter1.section5_UnionFind.QuickFindUF;
import book.chapter1.section5_UnionFind.QuickUnionUF;
import book.chapter1.section5_UnionFind.WeightQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.List;

public class Exercise22 {
    public class Experiment {
        int numberOfSites;
        int generatedConnections;
        double ratio;  // 用于验证增长级别，线性 or 平方

        public Experiment(int numberOfSites, int generatedConnections, double ratio) {
            this.numberOfSites = numberOfSites;
            this.generatedConnections = generatedConnections;
            this.ratio = ratio;
        }
    }

    public void makeExperiments(int numOfExperiment, int unionFindType) {
        int numOfSites = 2048;
        List<Experiment> experiments = new ArrayList<>();
        UF initialUnionFind = getUnionFindInstance(numOfSites / 2, unionFindType);
        Stopwatch initialTimer = new Stopwatch();
        erdosRenyi(numOfSites / 2, initialUnionFind);
        double previousTime = initialTimer.elapsedTime();

        for (int i = 0; i < numOfExperiment; i++) {
            UF uf = getUnionFindInstance(numOfSites, unionFindType);
            Stopwatch timer = new Stopwatch();
            int count = erdosRenyi(numOfSites, uf);
            double currentTime = timer.elapsedTime();
//            StdOut.println("currentTime: " + currentTime + "  previousTime: " + previousTime);
            experiments.add(new Experiment(numOfSites, count, currentTime / previousTime));
            numOfSites *= 2;
            previousTime = currentTime;
        }
        printResult(experiments);
    }

    private int erdosRenyi(int numberOfSites, UF unionFind) {
        int count = 0;
        while (unionFind.count() != 1) {
            int p = StdRandom.uniform(numberOfSites);
            int q = StdRandom.uniform(numberOfSites);
            count++;
            if (unionFind.find(p) != unionFind.find(q)) {
                unionFind.union(p, q);
            }
        }
        return count;
    }

    private UF getUnionFindInstance(int numberOfSites, int unionFindType) {
        switch (unionFindType) {
            case 1:
                return (UF) new QuickFindUF(numberOfSites);
            case 2:
                return (UF) new QuickUnionUF(numberOfSites);
            case 3:
                return (UF) new WeightQuickUnionUF(numberOfSites);
            default:
                return null;
        }
    }

    private void printResult(List<Experiment> experiments) {
        StdOut.printf("%12s %17s %23s %23s\n", "Experiment |",
                "Number of Sites |", "Pairs Generated |", "Ratio of Running Time");
        int index = 1;

        for (Experiment p : experiments) {
            StdOut.printf("%7d %13d %21d %23.1f\n", index, p.numberOfSites,
                    p.generatedConnections, p.ratio);
            index++;
        }
    }

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Exercise22 instance = new Exercise22();
        for (int i = 1; i <= 3; i++) {
            switch (i) {
                case 1:
                    StdOut.println("Quick Find");
                    break;
                case 2:
                    StdOut.println("Quick Union");
                    break;
                case 3:
                    StdOut.println("Weighted Quick Union");
                    break;
            }
            instance.makeExperiments(T, i);
        }
    }
}
