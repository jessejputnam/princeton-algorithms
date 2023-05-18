public interface UF {
    public int count();

    public void printId();

    public boolean connected(int p, int q);

    public int find(int p);

    public void union(int p, int q);
}
