import java.util.Arrays;

public class Arr {
    public static int binarySearch(double[] arr, double target) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;

        while (lo <= hi) {
            mid = (lo + hi) / 2;
            System.out.println("Mid: " + mid);
            if (target == arr[mid])
                return mid;
            if (target < arr[mid])
                hi = mid - 1;
            if (target > arr[mid])
                lo = mid + 1;
        }

        return -1;
    }

    public static double[] sort(double[] arr) {
        if (arr.length < 2)
            return arr;

        double[] left = sort(Arrays.copyOfRange(arr, 0, arr.length / 2));
        double[] right = sort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));

        return merge(left, right);
    }

    private static double[] merge(double[] a, double[] b) {
        int idxA, idxB, idx;
        idxA = idxB = idx = 0;
        double[] arr = new double[a.length + b.length];
        while (idxA < a.length || idxB < b.length) {
            if (idxA >= a.length)
                arr[idx++] = b[idxB++];
            else if (idxB >= b.length)
                arr[idx++] = a[idxA++];
            else if (a[idxA] < b[idxB])
                arr[idx++] = a[idxA++];
            else
                arr[idx++] = b[idxB++];
        }
        return arr;
    }
}
