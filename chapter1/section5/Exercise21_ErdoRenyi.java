package chapter1.section5;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Exercise21_ErdoRenyi {
    public static class Experiment {
        int numberOfSites;
        int generatedConnections;

        public Experiment(int numberOfSites, int genneratedConnections) {
            this.numberOfSites = numberOfSites;
            this.generatedConnections = genneratedConnections;
        }
    }

    private final int NUMBER_OF_EXPERIMENTS = 10;

    public void makeExperiments() {
        List<Experiment> experiments = new ArrayList<>();
        int numberOfSites = 16;

        for (int i = 0; i < NUMBER_OF_EXPERIMENTS; i++) {
            int genneratedConnections = Exercise17_RandomConnections.count(numberOfSites);
            experiments.add(new Experiment(numberOfSites, genneratedConnections));
            numberOfSites *= 2;
        }
        printResults(experiments);
    }

    public void printResults(List<Experiment> experiments) {
        StdOut.printf("%12s %17s %19s %10s %10s\n", "Experiment |", "Number of Sites |", "Pairs Generated |",
                "Expected |", "Accuracy |");

        int experimentId = 1;

        for (Experiment experiment : experiments) {
            double lnN = Math.log(experiment.numberOfSites);
            int expected = (int) (0.5 * lnN * experiment.numberOfSites);
            StdOut.printf("%7d %13d %19d %14d", experimentId, experiment.numberOfSites,
                    experiment.generatedConnections, expected);
            double accuracy = (double) experiment.generatedConnections / (double) expected;
            StdOut.printf("%12.1f\n", accuracy);
            experimentId++;
        }
    }

    public static void main(String[] args) {
        new Exercise21_ErdoRenyi().makeExperiments();
    }
}
//    $ java-algs4 chapter1/section5/Exercise21_ErdoRenyi.java
//    Experiment | Number of Sites |   Pairs Generated | Expected | Accuracy |
//        1            16                  34             22         1.5
//        2            32                  54             55         1.0
//        3            64                 228            133         1.7
//        4           128                 345            310         1.1
//        5           256                 643            709         0.9
//        6           512                1991           1597         1.2
//        7          1024                3284           3548         0.9
//        8          2048                6309           7807         0.8
//        9          4096               19010          17034         1.1
//        10          8192               38412          36908         1.0
