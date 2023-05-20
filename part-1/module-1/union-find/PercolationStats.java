
/******************************************************************************
 * Compilation: javac -cp {algs4} Percolation.java
 * Execution: java -cp {algs4} Main [int n, int trials]
 *
 * ---------------------------- REPLACE ---------------------------------
 * Runs Monte Carlo simulation on an n x n grid for a specified number of trials 
 * to determine the mean, standard deviation, and 95% confidence interval for when 
 * the system percolates.
 *
 * % java -cp {algs4} PercolationStats 50 1000
 * mean:                   = 0.5919035999999996
 * stddev:                 = 0.026293579051535374
 * 95% confidence interval = [0.590273907086245, 0.5935332929137542]
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] results;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        results = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);
            runSim(i, n, perc);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(results.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(results.length));
    }

    // test client (see below)
    public static void main(String[] args) {
        if (args.length != 2)
            throw noArgs();

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        if (n < 1 || trials < 1)
            throw badInput();

        PercolationStats stats = new PercolationStats(n, trials);

        printResults(stats);

    }

    public static void printResults(PercolationStats stats) {
        System.out.println("mean:                   = " + stats.mean());
        System.out.println("stddev:                 = " + stats.stddev());
        System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }

    public static IllegalArgumentException badInput() {
        return new IllegalArgumentException("Input must be greater than 0");
    }

    public static IllegalArgumentException noArgs() {
        return new IllegalArgumentException("Requires two arguments: int n, int trials");
    }

    private void runSim(int i, int n, Percolation perc) {
        while (!perc.percolates()) {
            int row = StdRandom.uniformInt(1, n + 1);
            int col = StdRandom.uniformInt(1, n + 1);
            if (!perc.isOpen(row, col))
                perc.open(row, col);
        }
        results[i] = perc.threshold();
    }
}
