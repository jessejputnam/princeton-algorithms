import java.util.Scanner;
import java.awt.geom.Point2D;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
// import java.util.Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Exercise 1.2.1
        // System.out.print("Number of points: ");
        // System.out.println("Example 1: " + ex1(scan.nextInt()));

        // Exercise 1.2.2
        // ArrayList<Interval1D[]> test = ex2(scan);
        // for (Interval1D[] in : test) {
        // System.out.println(in[0] + ", " + in[1]);
        // }

        // Exercise 1.2.3
        // ex3(Integer.parseInt(args[0]), Double.parseDouble(args[1]),
        // Double.parseDouble(args[2]));

        // Exercise 1.2.6
        System.out.println(ex6("ABCDEF", "BCDEFA"));

        scan.close();
    }

    public static double ex1(int n) {
        Random random = new Random();

        // Get n random points
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            Point2D newPoint = new Point2D.Double(x, y);
            points[i] = newPoint;
        }

        // Find shortest distance between two points
        double shortest = Double.POSITIVE_INFINITY;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = points[i].distance(points[j]);
                if (distance < shortest)
                    shortest = distance;
            }
        }

        return shortest;
    }

    public static ArrayList<Interval1D[]> ex2(Scanner scan) {
        ArrayList<Interval1D[]> intersecting = new ArrayList<>();

        System.out.print("Total intervals: ");
        int n = scan.nextInt();

        Interval1D[] intervals = new Interval1D[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Double 1: ");
            double x1 = scan.nextDouble();
            System.out.print("Double 2: ");
            double x2 = scan.nextDouble();
            System.out.println();

            Interval1D interval = new Interval1D(x1, x2);
            intervals[i] = interval;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    Interval1D[] pair = { intervals[i], intervals[j] };
                    intersecting.add(pair);
                }
            }
        }

        return intersecting;
    }

    public static void ex3(int n, double min, double max) {
        // double
        Interval2D[] boxes = new Interval2D[n];

        for (int i = 0; i < n; i++) {
            double[] xpts = { rand(min, max), rand(min, max) };
            Arrays.sort(xpts);
            Interval1D x = new Interval1D(xpts[0], xpts[1]);
            double[] ypts = { rand(min, max), rand(min, max) };
            Arrays.sort(ypts);
            Interval1D y = new Interval1D(ypts[0], ypts[1]);
            boxes[i] = new Interval2D(x, y);
        }

        for (Interval2D box : boxes) {
            box.draw();
        }
    }

    public static boolean ex6(String a, String b) {
        if (a.length() != b.length())
            return false;

        char a0 = a.charAt(0);
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == a0) {
                String check = b.substring(i) + b.substring(0, i);
                if (check.equals(a))
                    return true;
            }
        }
        return false;
    }

    private static double rand(double min, double max) {
        Random r = new Random();
        double spread = max - min;
        double random = min + r.nextDouble() * spread;
        return random;
    }
}
