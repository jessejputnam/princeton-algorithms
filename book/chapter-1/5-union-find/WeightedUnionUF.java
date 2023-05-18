import java.util.Arrays;

public class WeightedUnionUF implements UF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedUnionUF(int n) {
        count = n;
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j)
            return;

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public void printId() {
        System.out.println("ID: " + Arrays.toString(id));
        System.out.println("Weight: " + Arrays.toString(sz));
    }
}
