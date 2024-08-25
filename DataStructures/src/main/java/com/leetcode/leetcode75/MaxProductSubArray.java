package com.leetcode.leetcode75;

public class MaxProductSubArray {
    public static void main(String[] args) {
        MaxProductSubArray maxProductSubArray = new MaxProductSubArray();
        int[] nums = {2, -5, 3,1, -4,0, -10, 2, 8};
        int solution = maxProductSubArray.maxProduct(nums);
        System.out.println("Solution:" +solution);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        long max_so_far = nums[0];
        long min_so_far = nums[0];
        long result = max_so_far;

        // https://leetcode.com/problems/maximum-product-subarray/editorial/
        for (int i = 1; i < nums.length; i++) {
            long curr = nums[i];

            // Calculate the potential maximum and minimum products
            //Math.max(a,b) and Min.max(a,b), only two numbers hence 2 times
            long temp_max = Math.max(
                    curr,
                    Math.max(max_so_far * curr, min_so_far * curr)
            );
            min_so_far = Math.min(
                    curr,
                    Math.min(max_so_far * curr, min_so_far * curr)
            );

            // Update max_so_far after min_so_far to avoid overwriting it
            max_so_far = temp_max; // this was the placeholder for max value.
            if (min_so_far < 0 && curr > (Integer.MIN_VALUE + 1) / min_so_far) {
                max_so_far = 1;
                min_so_far = 1;
            }
            // Update the result with the maximum product found so far
            result = Math.max(max_so_far, result);
        }

        return (int) result;
    }
}
