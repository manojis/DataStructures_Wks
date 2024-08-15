package com.leetcode.leetcode75;

public class MaxSubarray {
    public static void main(String[] args) {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaxSubarray().maxSubArray(input));
    }
    public int maxSubArray(int[] nums) {
        int[] arr = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }

        arr[0] = nums[0];
        int maxSum = nums[0];
        for(int i=1; i< nums.length; i++) {
            if(nums[i] < nums[i] + arr[i-1]) {
                arr[i] = nums[i] + arr[i-1];

            } else {
                arr[i] = nums[i];
            }
            if(maxSum < arr[i]){
                maxSum = arr[i];
            }
        }
        return maxSum;
    }
}
