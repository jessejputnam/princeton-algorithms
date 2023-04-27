
// import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Exercise 3
        // System.out.println(ex3(args));

        // Exercise 5
        // System.out.println(ex5(.00, .9));

        // Exercise 9
        // System.out.println(ex9(123456789));

        // Exercise 11
        // boolean[] t = { true, false, true, false, true, false, true };
        // boolean[] f = { false, true, false, true, false, true, false };
        // boolean[][] twoDimensionBoolean = { t, f, t, f, t, f, t, f, t };
        // System.out.println(ex11(twoDimensionBoolean));

        // Exercise 13
        // String[][] newArr = new String[5][7];
        // for (int i = 0; i < 5; i++) {
        // for (int j = 0; j < 7; j++) {
        // newArr[i][j] = "" + i + j;
        // }
        // }
        // String[][] result = ex13(newArr);

        // Exercise 15
        // int[] histoArr = { 1, 1, 3, 5, 4, 2, 2, 1, 5, 3, 4, 2, 3, 1, 6 };
        // int[] histogram = ex15(histoArr, 7);
        // System.out.println(Arrays.toString(histogram));
    }

    public static boolean ex3(String[] args) {
        if (args.length != 3) {
            System.out.println(args.length > 3 ? "Too many " : "Too few " + "arguments. Please use 3 agruments");
            return false;
        }

        int[] arguments = { Integer.valueOf(args[0]), Integer.valueOf(args[1]), Integer.valueOf(args[2]) };
        return arguments[0] == arguments[1] && arguments[1] == arguments[2];
    }

    public static boolean ex5(double x, double y) {
        return (x > 0 && x < 1) && (y > 0 && y < 1);
    }

    public static String ex9(int n) {
        if (n < 0) {
            System.out.println("Positive numbers only");
            return "error";
        }

        if (n == 0)
            return "0";

        String binary = "";
        for (int i = n; i > 0; i /= 2) {
            binary = (i % 2) + binary;
        }

        return binary;
    }

    public static String ex11(boolean[][] input) {
        String output = "";

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                output += "[" + i + ", " + j + "]: " + (input[i][j] == true ? "*" : " ") + " ";
            }
            output += "\n";
        }

        return output;
    }

    public static String[][] ex13(String[][] arr) {
        String[][] newArr = new String[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[j][i] = arr[i][j];
            }
        }

        return newArr;
    }

    public static int[] ex15(int[] a, int m) {
        int[] histogram = new int[m];

        for (int i = 0; i < a.length; i++) {
            histogram[a[i]]++;
        }

        return histogram;
    }

}