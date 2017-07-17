/**
 *
 */
package com.Misc;

/**
 * @author Manoj.Mohanan Nair
 */
public class TestClass {

    private static int max = 20;

    public static int fibonacci(int data) {
        int[] fib = new int[max];

        if (data == 0)
            return 0;
        else if (data == 1)
            return 1;
        else if (fib[data] != 0)
            return fib[data];
        fib[data] = fibonacci(data - 1) + fibonacci(data - 2);

        return fib[data];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x = 10;

        x = fibonacci(x);
    }

}
