import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1.4.16
        double[] arr = { 30, 1, 23, 40, 99, 98, 37, 101, 90, 129, 150, 3, 18, 64, 100, 300, 250, 101.5, 90.3 };
        System.out.println(Arrays.toString(closestPair(arr)));
        System.out.println(Arrays.toString(furthestPair(arr)));
    }

    public static double[] closestPair(double[] arr) {
        arr = Arr.sort(arr);
        double lo = arr[0], hi = arr[1];

        for (int i = 1; i < arr.length - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            if ((hi - lo) > diff) {
                lo = arr[i];
                hi = arr[i + 1];
            }
        }

        return new double[] { lo, hi };
    }

    public static double[] furthestPair(double[] arr) {
        double lo = Double.POSITIVE_INFINITY, hi = Double.NEGATIVE_INFINITY;

        for (double num : arr) {
            if (num < lo)
                lo = num;
            if (num > hi)
                hi = num;
        }
        return new double[] { lo, hi };
    }
}