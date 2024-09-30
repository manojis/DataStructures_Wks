package com.leetcode.leetcode75;

import java.util.HashMap;

public class SubarraySumEqualsK_560 {
     public static void main(String[] args) {
         int [] nums = {-2, 1, 2, -2, 5, -2, 1};
         SubarraySumEqualsK_560 ex = new SubarraySumEqualsK_560();
         System.out.println(ex.subarraySum(nums, 3));
     }

    /**
     * The below solution has O(n^2). This can be optimized again to O(n) using hashmap. Try this later.
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // Create a prefix sum array
        // Find out subarrays by looping through having value equal to k when the prefixsum(0,n) - prefixsum
        // loop j through the first pointer from 0 -> n in prefix sum
        // loop i through the second pointer from 0 -> n-1 in prefix sum
        // subract arr[j] - arr[i], if that is equal to k, basically it means i+1 -> j is a subarray which satisfies the condition
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        int count = 0;

        //     {-2, 1, 2, -2, 5, -2, 1}
        //p s: {-2, -1, 1, -1, 4, 2, 3 }
        // prefixSum[j] - k = prefixSum[0, i-1]
        // This will store the prefixsum in the corresponding arrays

        for (int i = 0; i< nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }

        for (int j=0; j< prefixSum.length; j++) {
            // Need to calculate from i-1
            if (prefixSum[j] == k) {
                count++;
                //System.out.println("count-1:"+ count);
            }
        }

        for (int j=1; j<prefixSum.length; j++) {
            //System.out.println("prefixSum[j]: "+ prefixSum[j] + " k:" + k);
            int diff = prefixSum[j] - k;
            for(int i=1; i<=j; i++) {
                //System.out.println("prefixSum[j]-k: "+diff + " prefixSum[i-1]: " + prefixSum[i-1]);
                if (diff == prefixSum[i-1]) {
                    count++;
                }
                //System.out.println("count-2:"+ count);
            }
        }
        return count;
    }
}

