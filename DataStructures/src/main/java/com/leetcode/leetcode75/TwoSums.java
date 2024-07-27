package com.leetcode.leetcode75;

import java.util.HashMap;

public class TwoSums {
    public static void main(String[] args) {
        int [] nums = {3,2,4};
        int [] output = twoSums(nums, 6);
        if (output!= null) {
            System.out.println("Output: "+output[0]+", "+output[1]);
        } else {
            System.out.println("No matching values");
        }
        
    }
    // The below solution won't work for unsorted inputs
    public static int[] twoSum(int[] nums, int target) {
        int j=nums.length-1;
        for (int i=0;i<=j-1;) {
            int sum = nums[i] + nums[j];
            if(sum == target) {
                return new int[] {nums[i], nums[j]};
            } else if (sum < target){
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    // loop from one end and check if diff already exists in the hashmap else add for checking with next one
    public static int[] twoSums(int[] nums, int target) {
        HashMap<Integer, Integer> input = new HashMap<Integer, Integer>();
        for (int i=0; i<=nums.length-1; i++){
            int diff = target - nums[i];
            if (input.containsKey(diff)) {
                return new int[]{nums[i], diff};
            } else {
                input.put(nums[i], i);
            }
        }        
        return null;
    }


}
