import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class WeightedQuickUnion {
    private int[] id;   // access to component id (site indexed)
    private int[] sz;   // tracking weight of each tree
    private int count;  // number of components

    public WeightedQuickUnion(int N){
        // Initialize component id array
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j) { return; }

        if (sz[p] < sz[q]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[i] += sz[j]; }

        count--;

        StdOut.println(Arrays.toString(id));
        StdOut.println(Arrays.toString(sz));
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();    // Read number of sites
        WeightedQuickUnion uf = new WeightedQuickUnion(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
            StdOut.println(p + " " + q);
            StdOut.println("count: " + uf.count());
        }
        StdOut.println(uf.count() + " components");
    }
}
