package com.leetcode;

import java.util.*;

public class MaxRectangleAreaWithReductionArr {
    private static final int MOD = 1_000_000_007;
    private static final int MAX_STICK_LENGTH = 1000;

    public static int maxRectangleArea(List<Integer> sticks) {
        // Step 1: Count occurrences of each stick length using an array
        int[] lengthCount = new int[MAX_STICK_LENGTH + 1];
        for (int stick : sticks) {
            lengthCount[stick]++;
        }

        // Step 2: Collect pairs in descending order and calculate area
        List<Integer> pairs = new ArrayList<>();
        long maxArea = 0;

        // Process from the largest possible length downwards
        for (int length = MAX_STICK_LENGTH; length >= 1; length--) {
            // Form pairs directly if count is even
            while (lengthCount[length] >= 2) {
                pairs.add(length);
                lengthCount[length] -= 2;
            }

            // Check if we can pair an odd leftover count by reducing length by 1
            if (lengthCount[length] == 1 && lengthCount[length - 1] > 0) {
                pairs.add(length - 1);
                lengthCount[length] = 0;
                lengthCount[length - 1]--;
            }
        }

        // Step 3: Calculate area by using pairs to form rectangles
        for (int i = 0; i + 1 < pairs.size(); i += 2) {
            int length1 = pairs.get(i);
            int length2 = pairs.get(i + 1);
            maxArea = (maxArea + (long) length1 * length2) % MOD;
        }

        return (int) maxArea;
    }

    public static void main(String[] args) {
        List<Integer> sticks1 = Arrays.asList(3, 4, 5, 5, 6);
        System.out.println("Output for [3, 4, 5, 5, 6]: " + maxRectangleArea(sticks1)); // Expected: 15

        List<Integer> sticks2 = Arrays.asList(8, 2, 3, 3, 4, 6, 8, 8, 6);
        System.out.println("Output for [8, 2, 3, 3, 4, 6, 8, 8, 6]: " + maxRectangleArea(sticks2)); // Expected: 54

        List<Integer> sticks3 = Arrays.asList(2, 3, 3, 4, 6, 8, 8, 6);
        System.out.println("Output for [2, 3, 3, 4, 6, 8, 8, 6]: " + maxRectangleArea(sticks3)); // Expected: 54
    }

}
