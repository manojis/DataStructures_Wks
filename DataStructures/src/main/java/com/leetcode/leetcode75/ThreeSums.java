package com.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {
    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4};

        List<List<Integer>> output = threeSum(input);
        System.out.println("output:" +output);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        // taking each of the element from the list
        // The below sort is nlog(n) time complexity
        Arrays.sort(nums);
        for(int i =0; i<nums.length-1; i++) {
            if (nums[i]> 0) {
                return output;
            }
            if(i >0 && nums[i] == nums[i-1]) {
                continue;
            } else {
                int k = nums.length -1;
                for (int j=i+1; j<k;) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0) {
                        k--;
                    } else if(sum<0){
                        j++;
                    } else {
                        output.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        // to ensure duplicates dont come in
                        while(nums[j]==nums[j-1] && j<k) {
                            j++;
                        }
                    }
                }
            }
        }
        return output;
    }
}
