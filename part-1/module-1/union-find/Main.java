import edu.princeton.cs.algs4.StdRandom;

public class Main {
    public static void main(String[] args) {
        int n = 25;
        Percolation perc = new Percolation(n);
        runSim(n, perc);
    }

    private static void runSim(int n, Percolation perc) {
        clearScreen();
        perc.print();
        while (!perc.percolates()) {
            int row = StdRandom.uniformInt(1, n + 1);
            int col = StdRandom.uniformInt(1, n + 1);
            if (!perc.isOpen(row, col)) {
                perc.open(row, col);
                pause(20);
                clearScreen();
                perc.print();
            }
        }
    }

    private static void pause(int ms) {
        try {
            Thread.sleep(ms); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
