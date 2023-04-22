/*
 * Write a program HelloGoodbye.java that takes two names as command-line
 * arguments and prints hello and goodbye messages as shown below (with the
 * names for the hello message in the same order as the command-line arguments
 * and with the names for the goodbye message in reverse order).
 */

public class HelloGoodbye {
    public static void main(String[] args) {
        if (args.length > 2) {
            System.out.println("Please use only two names");
            return;
        }

        System.out.println("Hello " + args[0] + " and " + args[1] + ".");
        System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");
    }
}