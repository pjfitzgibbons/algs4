import edu.princeton.cs.algs4.StdOut;

public class FifteenOnes
{
    public static void main(String[] args) 
    {
        java.math.BigInteger f = new java.math.BigInteger("0");
        java.math.BigInteger g = new java.math.BigInteger("1");
        for (int i = 0; i <= 1000; i++)
        {
            StdOut.println(f);
            f = f.add(g);
            g = f.subtract(g);
        }
        StdOut.println(f.toString().length());
    }
}