import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        boolean isFile = System.console() == null;
        String champion = "";

        if (!isFile) {
            String line = StdIn.readLine();

            for (int i = 1; !StdIn.isEmpty(); i++) {
                String word = StdIn.readString();
                System.out.println(i + ": " + word);

            }
            // int wordNum = 0;
            // String line = StdIn.readLine();

            // StdOut.println(StdIn.readString());
        } else {
            for (int i = 1; !StdIn.isEmpty(); i++) {
                boolean chance = StdRandom.bernoulli(1.0 / i);
                String contender = StdIn.readString();
                if (chance) {
                    champion = contender;
                }
            }
        }

        System.out.println(champion);

        // for (int i = 1; !StdIn.isEmpty(); i++) {
        // // System.out.println(StdIn.readString());
        // boolean check = StdRandom.bernoulli(1.0 / i);
        // String word = StdIn.readString();
        // System.out.println(check);
        // if (check) {
        // System.out.println(word);
        // break;
        // }
        // }

        // boolean nextLine = StdIn.hasNextLine();
        // while (nextLine) {
        // System.out.println("String: " + StdIn.readString());
        // System.out.println("Empty: " + StdIn.isEmpty());

        // }
    }
}