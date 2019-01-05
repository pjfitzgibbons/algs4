import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class UF {
    private int[] id;   // access to component id (site indexed)
    private int count;  // number of components

    public UF(int N){
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
        return id[p];
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
        int pId = id[p];
        int qId = id[q];
        if (pId == qId) { return; }

        for (int i = 0; i < id.length; i ++) {
            if ( id[i] == qId ) {
                id[i] = pId;
                StdOut.println("id[" + i + "]:" + qId + " => " + pId);
            }
        }

        count--;

        StdOut.println(Arrays.toString(id));
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();    // Read number of sites
        UF uf = new UF(N);
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
