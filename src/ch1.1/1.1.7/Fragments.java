import edu.princeton.cs.algs4.StdOut;

public class Fragments
{
    public static void main(String[] args) {
        a();
        b();
        c();
        d();
    }

    private static void a() {
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
        {
            t = (9.0/t + t) / 2.0;
        }
        StdOut.printf("A: %.5f\n", t);
    }

    private static void b() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
        {
            for (int j = 0; j < i; j++)
            {
                sum++;
            }
        }
        StdOut.println("B: " + Integer.toString(sum));
    }

    private static void c() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }            
        }
        StdOut.printf("C: %d\n", sum);
    }
    private static void d() {
        StdOut.print("D: ");
        System.out.println((char) ('a' + 4));
    }
}