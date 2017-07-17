/**
 *
 */
package com.Puzzles;

/**
 * @author Manoj.Mohanan Nair
 */
/* Name of the class has to be "Main" only if the class is public. */
public class ideone {
    public static void main(String[] args) throws java.lang.Exception {
        int n = 10;
        int x = 4;
        long time = System.nanoTime();
        System.out.println(power(n, x) + " Time: " + (System.nanoTime() - time));

        time = System.nanoTime();
        System.out.println(Math.pow(n, x) + " Time: " + (System.nanoTime() - time));
    }

    public static long power(long n, int x) {
        long pow = 1;
        long exp = n;
        while (x > 0) {
            if ((x & 1) == 1) {
                pow *= exp;
                System.out.println(pow + " " + (x & 1));
            }
            exp *= exp;
            x = x >> 1;
            System.out.println("second val" + exp + " " + (x));
        }
        return pow;
    }
}