package com.leetcode.leetcode75;

public class Min_Rotated_sorted_Array_153 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,1,2};
        Min_Rotated_sorted_Array_153 minRotatedSortedArray153 = new Min_Rotated_sorted_Array_153();
        int smallest = minRotatedSortedArray153.findMin(nums);
        System.out.println(smallest);
    }

    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = length-1;
        while(nums[left] > nums[right]) {
            // there is rotation
            int mid = (right - left)/2;
            if (nums[left + mid] > nums[right]) {
                if ((left+ mid +1) == right) {
                    if(nums[left] > nums[right]) {
                        return nums[right];
                    } else {
                        return nums[left];
                    }
                }
                left = left + mid+1;
            } else {
                right = right- mid;
            }
        }
        return nums[left];
    }
}
