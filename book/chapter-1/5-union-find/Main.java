import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            UF uf = new WeightedUnionUF(n);

            while (scan.hasNext()) {
                int p = scan.nextInt();
                int q = scan.nextInt();
                if (uf.connected(p, q))
                    continue;
                uf.union(p, q);
            }

            System.out.println(uf.count() + " components");
            uf.printId();

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return;
        }
    }
}