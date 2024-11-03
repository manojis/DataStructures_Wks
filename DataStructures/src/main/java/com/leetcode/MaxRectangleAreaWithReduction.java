package com.leetcode;

import java.util.*;

public class MaxRectangleAreaWithReduction {
    private static final int MOD = 1_000_000_007;
    private static final int MAX_STICK_LENGTH = 1000;

    public static int maxRectangleArea(int[] sticks) {
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
        int[] sticks1 = {3, 4, 5, 5, 6};
        System.out.println("Output for [3, 4, 5, 5, 6]: " + maxRectangleArea(sticks1)); // Expected: 15

        int[] sticks2 = {8, 2, 3, 3, 4, 6, 8, 8, 6};
        System.out.println("Output for [8, 2, 3, 3, 4, 6, 8, 8, 6]: " + maxRectangleArea(sticks2)); // Expected: 54

        int[] sticks3 = {2, 3, 3, 4, 6, 8, 8, 6};
        System.out.println("Output for [2, 3, 3, 4, 6, 8, 8, 6]: " + maxRectangleArea(sticks3)); // Expected: 54
    }

    /*public static int maxRectangleArea(int[] sticks) {
        // Step 1: Count occurrences of each stick length
        Map<Integer, Integer> lengthCount = new HashMap<>();
        for (int stick : sticks) {
            lengthCount.put(stick, lengthCount.getOrDefault(stick, 0) + 1);
        }

        // Step 2: Collect pairs, allowing reductions if beneficial
        List<Integer> pairs = new ArrayList<>();

        for (int length : new TreeSet<>(lengthCount.keySet()).descendingSet()) {
            int count = lengthCount.get(length);

            // Form pairs from the current length
            while (count >= 2) {
                pairs.add(length);
                count -= 2;
            }

            // If there's an odd leftover stick, check if length - 1 can be used to form a pair
            if (count == 1 && lengthCount.getOrDefault(length - 1, 0) > 0) {
                pairs.add(length - 1);
                lengthCount.put(length - 1, lengthCount.get(length - 1) - 1);
            }
        }

        // Step 3: Sort pairs in descending order to maximize area
        Collections.sort(pairs, Collections.reverseOrder());

        // Step 4: Calculate the maximum area by forming rectangles from pairs
        long maxArea = 0;
        for (int i = 0; i + 1 < pairs.size(); i += 2) {
            int length1 = pairs.get(i);
            int length2 = pairs.get(i + 1);
            maxArea = (maxArea + (long) length1 * length2) % MOD;
        }

        return (int) maxArea;
    }*/
}
