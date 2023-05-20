import java.util.Arrays;

public class UF {
    private int[] id;
    private int[] sz;
    private int sqrt;

    public UF(int n) {
        sqrt = (int) Math.sqrt(n);
        id = new int[n + 2];
        sz = new int[n + 2];
        for (int i = 0; i < n + 2; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        for (int i = 1; i < sqrt + 1; i++)
            union(0, i);

        for (int i = n; i > n - sqrt; i--)
            union(n + 1, i);
    }

    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID)
            return;

        if (sz[pID] < sz[qID]) {
            id[pID] = qID;
            sz[qID] += sz[pID];
        } else {
            id[qID] = pID;
            sz[pID] += sz[qID];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(id) + "\n" + Arrays.toString(sz);
    }
}
