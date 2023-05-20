/**
 */

public class Percolation {
    private Node[] id;
    private int open;
    private int sqrt;
    private int top;
    private int len;

    public Percolation(int n) {
        sqrt = n;
        top = -1;
        len = n * n;
        id = new Node[len];
        for (int i = 0; i < (len); i++)
            id[i] = new Node(i);
        open = 0;
    }

    public void open(int row, int col) {
        int idx = getIdx(row, col);

        // open node
        id[idx].open = true;
        open++;

        connectOpen(row, col, idx);
    }

    public boolean isOpen(int row, int col) {
        int idx = getIdx(row, col);
        return id[idx].open;
    }

    public boolean isFull(int row, int col) {
        int idx = getIdx(row, col);
        return find(idx) == top;
    }

    public boolean isFull(int idx) {
        return find(idx) == top;
    }

    public int numberOfOpenSites() {
        return open;
    }

    public void print() {
        String output = "";
        for (int i = 0; i < len; i++) {
            if (!id[i].open)
                output += "#";
            else
                output += isFull(i) ? "O" : ".";

            if ((i + 1) % sqrt == 0)
                output += "\n";
        }
        System.out.println(output);
    }

    // public boolean percolates() {

    // }

    private int find(int p) {
        while (p != top && p != len && p != id[p].val) {
            int val = id[p].val;
            id[p].val = (val == top)
                    ? top
                    : (val == len)
                            ? len
                            : id[id[p].val].val;
            p = id[p].val;
        }
        return p;
    }

    private void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID)
            return;

        // q's root is top or bottom
        if (qID == top || qID == len) {
            id[pID].val = qID;
            return;
        }

        // p's root is top or bottom
        if (pID == top || pID == len) {
            id[qID].val = pID;
            return;
        }

        // q's root is larger
        if (id[pID].size < id[qID].size) {
            id[pID].val = qID;
            id[qID].size += id[pID].size;
            return;
        }

        // p's root is larger
        id[qID].val = pID;
        id[pID].size += id[pID].size;
    }

    private void connectOpen(int row, int col, int idx) {
        unionUp(row, col, idx);
        unionRight(row, col, idx);
        unionDown(row, col, idx);
        unionLeft(row, col, idx);
    }

    private void unionUp(int row, int col, int idx) {
        int up = row == 0 ? top : getIdx(row - 1, col);
        if (up == top || id[up].open)
            union(up, idx);
    }

    private void unionRight(int row, int col, int idx) {
        int right = getIdx(row, col + 1);
        if (col < sqrt - 1)
            union(right, idx);
    }

    private void unionDown(int row, int col, int idx) {
        int down = row == sqrt - 1 ? len : getIdx(row + 1, col);
        if (down == len || id[down].open)
            union(down, idx);
    }

    private void unionLeft(int row, int col, int idx) {
        int left = getIdx(row, col - 1);
        if (col > 0)
            union(left, idx);
    }

    private int getIdx(int row, int col) {
        return (row * sqrt) + col;
    }

    private class Node {
        int val;
        int size;
        boolean open;

        private Node(int val) {
            this.val = val;
            size = 1;
            open = false;
        }
    }
}
