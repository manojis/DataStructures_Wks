package com.leetcode;

/**
 * @author Manoj.Mohanan Nair
 * @Date 11/29/19
 */
public class squareroot {
    public static void main(String[] args){
        int x = 4;
        int out = mySqrt(x);
        System.out.println(out);
        //System.out.println(floorSqrt(x));
    }
    // better solution
    // time complexity = O(logN)
    // Space complexity = O(1)
    public static int mySqrt(int x) {
        if (x < 2){
            return x;
        }

        long num;
        int pivot, left = 2, right = x / 2;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }
        return right;
    }

    // my solution
    public static int floorSqrt(int x)
    {
        //
        if (x == 0 || x == 1)
            return x;

        // Do Binary Search for floor(sqrt(x))
        int start = 1, end = x, ans=0;
        while (start <= end)
        {
            int mid = (start + end) / 2;
            System.out.println("while loop x:"+x +" start: "+ start +" end: "+ end +" mid: " + mid);

            // If x is a perfect square
            if (mid*mid == x) {
                System.out.println("EQUAL x: "+mid);
                return mid;
            }

            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid*mid < x)
            {
                System.out.println("LESS THAN x: "+mid);
                start = mid + 1;
                ans = mid; //** This is the most critical condition alongwith while loop
                // as soon as the start goes greater than the end, you get out of the loop and return that value.
            }
            else {  // If mid*mid is greater than x
                System.out.println("GREATER THAN x: "+mid);
                end = mid-1;
            }
        }
        return ans;
    }
}
