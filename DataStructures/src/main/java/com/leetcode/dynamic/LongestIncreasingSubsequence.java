package com.leetcode.dynamic;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] input = new int[]{5,7,4,-3,9,1,10,4,5,8,9,3};
        LongestIncreasingSubsequence ls = new LongestIncreasingSubsequence();
        System.out.println("" + ls.lengthOfLIS(input));
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] lis = new int[length];
        for (int i = 0; i<length; i++) {
            lis[i] = 1;
            for (int j = 0; j<i; j++) {
                if (nums[j] < nums[i] && lis[i] < 1 + lis[j]) {
                    lis[i] = 1+ lis[j];
                }
            }
        }

        int max = 0;
        for(int k =0; k <length; k++) {
            if (lis[k]> max) {
                max = lis[k];
            }
        }
        return max;
    }
}
