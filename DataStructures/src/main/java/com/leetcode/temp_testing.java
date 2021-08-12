package com.leetcode;

/**
 * @author Manoj.Mohanan Nair
 * @Date 11/28/19
 * for testing the binary search criteria
 */
public class temp_testing {
    public static void main(String[] args){
        // call the method from here
        int[] nums = {2,4,5,6,9};
        int result =  search(nums, 9);
    }

    public static int search(int[] nums, int target) {
        int midIndex = nums.length/2;
        int[] outputTemp;
        if(nums.length %2 == 0){
            outputTemp = new int[midIndex];
        }else {
            outputTemp = new int[midIndex+1];
        }
        if(nums[midIndex] < target){
            for(int i=midIndex; i<nums.length;i++){
                outputTemp[i - midIndex] = nums[i];
            }
            search(outputTemp, target);
        }else {
            for(int i=0; i< midIndex; i++){
                outputTemp[i] = nums[i];
            }
            search(outputTemp, target);
        }
        return -1;
    }
}
