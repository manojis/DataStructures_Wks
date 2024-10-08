package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author Manoj.Mohanan Nair
 * @Date 10/6/24
 */
public class SlidingWindowMaximum_239 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,2,0,5};
        int[] Output = maxSlidingWindow(nums, 3);
    }

    /**
     * Things to remember here
     * Using peek() provides the first element in the queue which was pushed
     * Same for pop() pushes out the first element pushed into the queue
     *
     * Use < peekFirst(), peekLast(), pollfirst(), pollLast() and removeFirst()> in a Deque**.
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> input = new ArrayDeque<>();
        ArrayList<Integer> output = new ArrayList<>();

        for(int i = 0; i<= nums.length; i++) {
            if((i-k)>=0) {
                output.add(nums[input.peekFirst()]);
                if ((i-k)==input.peekFirst()) {
                    input.removeFirst();
                }
            }

            while(i < nums.length && (input.peekLast() != null && nums[input.peekLast()] < nums[i])) {
                input.pollLast();
            }

            if (i<nums.length) {
                input.add(i);
            }
        }

        int [] arr = output.stream().mapToInt(i->i).toArray();
        return arr;
    }
}
