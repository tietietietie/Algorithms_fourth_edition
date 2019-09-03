/* *****************************************************************************
 *  Name:PercolationStats
 *  Date:2019.9.3
 *  Description:Monte Carlo simulation
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] x;
    private double x_mean;
    private double x_stddev;
    private double x_confilow;
    private double x_confihigh;


    public PercolationStats(int n, int trials) {
        x = new double[trials];
        for (int i = 0; i < trials; i++) {
            int times = 0;
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (perc.isOpen(row, col))
                    continue;
                perc.open(row, col);
                times++;
            }
            x[i] = times / (double) (n * n);
        }
        x_mean = StdStats.mean(x);
        x_stddev = StdStats.stddev(x);
        x_confilow = x_mean - 1.96 * Math.sqrt(x_stddev) / Math.sqrt(trials);
        x_confihigh = x_mean + 1.96 * Math.sqrt(x_stddev) / Math.sqrt(trials);
    }

    public double mean() {
        return x_mean;

    }

    public double stddev() {
        return x_stddev;
    }

    public double cofidenceLo() {
        return x_confilow;
    }

    public double confidenHi() {
        return x_confihigh;
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats percstats = new PercolationStats(n, trials);
        StdOut.printf("%-25s = %f\n", "mean", percstats.mean());
        StdOut.printf("%-25s = %f\n", "stddev", percstats.stddev());
        StdOut.printf("%-25s = [%f, %f]\n", "95% confidence interval", percstats.cofidenceLo(),
                      percstats.confidenHi());

    }
}
