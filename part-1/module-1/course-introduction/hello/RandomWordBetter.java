import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Scanner;

public class RandomWordBetter {
    public static void main(String[] args) {
        boolean isFile = System.console() == null;
        String champion = "";

        String line = isFile ? null : StdIn.readLine();
        Scanner scanner = isFile ? null : new Scanner(line);

        for (int i = 1; isFile ? !StdIn.isEmpty() : scanner.hasNext(); i++) {
            boolean chance = StdRandom.bernoulli(1.0 / i);
            String contender = isFile ? StdIn.readString() : scanner.next();
            if (chance) {
                champion = contender;
            }
        }

        if (!isFile)
            scanner.close();

        System.out.println(champion);
    }
}
