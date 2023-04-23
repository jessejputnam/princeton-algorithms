
/******************************************************************************
 * Compilation: javac -cp .:path/to/algs4 RandomWord.java
 * Execution: java -cp .:path/to/algs4 RandomWord.java
 *
 * Reads a sequence of words from standard input and prints one of those words uniformly 
 * at random. Words are not stored in an array, but use Knuth’s method of reading the ith word, 
 * selecting it with probability 1/i to be the champion, replacing the previous champion. 
 * Prints the champion on completion of reading all words.
 *
 * % java -cp .:path/to/algs4 HelloWorld
 * heads tails
 * heads
 *
 * % java -cp .:path/to/algs4 RandomWord < animals8.txt
 * emu
 ******************************************************************************/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Scanner;

public class RandomWord {
    public static void main(String[] args) {
        boolean isFile = System.console() == null;
        String champion = "";

        if (!isFile) {
            String line = StdIn.readLine();
            Scanner scanner = new Scanner(line);

            for (int i = 1; scanner.hasNext(); i++) {
                boolean chance = StdRandom.bernoulli(1.0 / i);
                String contender = scanner.next();
                if (chance) {
                    champion = contender;
                }
            }
            scanner.close();
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
    }
}