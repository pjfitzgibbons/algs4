import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class QuickUnion {
    private int[] id;   // access to component id (site indexed)
    private int count;  // number of components

    public QuickUnion(int N){
        // Initialize component id array
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return root(p);
    }

    public int root(int p) {
        int pt = p;
        int next = id[pt];
        while (next != pt) {
            pt = next;
            next = id[pt];
        }
        return pt;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if (pRoot == qRoot) { return; }

        id[qRoot] = pRoot;

        count--;

        StdOut.println(Arrays.toString(id));
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();    // Read number of sites
        QuickUnion uf = new QuickUnion(N);
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
