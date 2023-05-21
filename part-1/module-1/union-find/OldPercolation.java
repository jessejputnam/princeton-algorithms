/**
 * Percolation System Model
 * 
 * By convention, the row and column indices are integers between 1 and n, where
 * (1, 1) is the upper-left site
 * 
 * Model a percolation system using an n-by-n grid of sites. Each site is
 * either open or blocked. A full site is an open site that can be connected to
 * an open site in the top row via a chain of neighboring (left, right, up,
 * down) open sites. The system percolates if there is a full site in the
 * bottom row. In other words, a system percolates if, in filling all open sites
 * connected to the top row, that process fills some open site on the bottom
 * row.
 */

public class OldPercolation {
    private Node[] id;
    private int sqrt;
    private int len;

    public OldPercolation(int n) {
        if (n < 1)
            throw errIllArg("Requires int larger than 0");
        sqrt = n;
        len = n * n;
        id = new Node[len + 2];
        for (int i = 0; i < (len + 2); i++)
            id[i] = new Node(i);
        id[0].open = true;
        id[len + 1].open = true;
    }

    /** Opens specified cell and connects to adjacent open cells */
    public void open(int row, int col) {
        if (row < 1 || row > sqrt || col < 1 || col > sqrt)
            throw errIllArg("Indices must be between 1 and n");

        int idx = getIdx(row, col);
        id[idx].open = true;
        connectToOpenCells(row, col, idx);
    }

    /** Checks if cell is open, full or empty */
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > sqrt || col < 1 || col > sqrt)
            throw errIllArg("Indices must be between 1 and n");

        int idx = getIdx(row, col);
        return id[idx].open;
    }

    /** Checks if cell is full with coords */
    public boolean isFull(int row, int col) {
        if (row < 1 || row > sqrt || col < 1 || col > sqrt)
            throw errIllArg("Indices must be between 1 and n");
        int idx = getIdx(row, col);
        return find(idx) == find(0);
    }

    /** Checks how many cells are open, empty or full */
    public int numberOfOpenSites() {
        int total = 0;
        for (int i = 1; i < len + 1; i++)
            if (id[i].open)
                total++;
        return total;
    }

    /** Checks if there exists a path from top to bottom */
    public boolean percolates() {
        return find(0) == find(len + 1);
    }

    /** Finds connected root of idx */
    private int find(int p) {
        while (p != id[p].val) {
            id[p].val = id[id[p].val].val;
            p = id[p].val;
        }
        return p;
    }

    /** Joins two nodes by root */
    private void union(int p, int q) {
        int pID = find(p), qID = find(q);
        if (pID == qID)
            return;

        if (id[pID].size < id[qID].size) { // q's root is larger
            id[pID].val = qID;
            id[qID].size += id[pID].size;
        } else { // p's root is larger or equal
            id[qID].val = pID;
            id[pID].size += id[pID].size;
        }
    }

    /** Joins cell to all open adjacent cells */
    private void connectToOpenCells(int row, int col, int idx) {
        unionUp(row, col, idx);
        unionRight(row, col, idx);
        unionDown(row, col, idx);
        unionLeft(row, col, idx);
    }

    /** Joins above cell if open */
    private void unionUp(int row, int col, int idx) {
        int up = (row == 1) ? 0 : getIdx(row - 1, col);
        if (id[up].open)
            union(up, idx);
    }

    /** Joins right cell if open */
    private void unionRight(int row, int col, int idx) {
        if (col == sqrt)
            return;
        int right = getIdx(row, col + 1);
        if (id[right].open)
            union(right, idx);
    }

    /** Joins down cell if open */
    private void unionDown(int row, int col, int idx) {
        int down = (row == sqrt) ? len + 1 : getIdx(row + 1, col);
        if (id[down].open)
            union(down, idx);
    }

    /** Joins left cell if open */
    private void unionLeft(int row, int col, int idx) {
        if (col == 1)
            return;
        int left = getIdx(row, col - 1);
        if (id[left].open)
            union(left, idx);
    }

    /** Gets array index from coords */
    private int getIdx(int row, int col) {
        return ((row - 1) * sqrt) + col;
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

    public void print() {
        String output = "-------------------\n\n";

        for (int i = 1; i < len + 1; i++) {
            if (!id[i].open)
                output += "⬛️";
            else
                output += isFull(i) ? "🟦" : "⬜️";

            if ((i) % sqrt == 0)
                output += "\n";
        }
        System.out.println(output + "\n-------------------");
    }

    /** Checks if cell is full with coords */
    private boolean isFull(int idx) {
        return find(idx) == find(0);
    }

    private IllegalArgumentException errIllArg(String msg) {
        return new IllegalArgumentException(msg);
    }
}
