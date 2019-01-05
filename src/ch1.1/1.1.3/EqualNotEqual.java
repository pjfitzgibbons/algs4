import edu.princeton.cs.algs4.StdOut;

public class EqualNotEqual {
    public static void main(String[] args)
    {
        int x = new Integer(args[0]);
        int y = new Integer(args[1]);
        int z = new Integer(args[2]);
        
        if (x == y && y == z) {
            StdOut.println("equal");
        }
        else
        {
            StdOut.println("not equal");
        }
    }
}