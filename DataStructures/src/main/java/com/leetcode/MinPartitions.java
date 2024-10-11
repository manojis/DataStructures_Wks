package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinPartitions {
    public static int minPartitions(List<Integer> used, List<Integer> totalCapacity) {
        // Step 1: Calculate the total amount of data that needs to be stored
        int totalData = 0;
        for (int space : used) {
            totalData += space;
        }

        // Step 2: Sort the totalCapacity array in descending order
        Collections.sort(totalCapacity);
        int n = totalCapacity.size();

        // Step 3: Greedily allocate the largest partitions first
        int partitionCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (totalData <= 0) {
                break; // All data has been allocated
            }
            partitionCount++;
            totalData -= totalCapacity.get(i); // Allocate partition capacity
        }

        return partitionCount;
    }

    public static void main(String[] args) {
        // Example usage
        Integer[] used = {3,2,1,3,1}; // Space used in each partition
        Integer[] totalCapacity = {3, 5, 3, 5, 5}; // Total capacity of each partition

        int result = minPartitions(Arrays.asList(used), Arrays.asList(totalCapacity));
        System.out.println("Minimum number of partitions required: " + result);
    }
}
