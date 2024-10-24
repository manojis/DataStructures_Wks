package com.HackerRank;

import java.util.*;

public class KMostFrequentStrings {
    public static List<String> findKMostFrequent(String[] strings, int k) {
        // Step 1: Count the frequency of each string
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : strings) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        // Step 2: Use a PriorityQueue to keep track of top k elements
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        // Step 3: Maintain the heap size to k
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest frequency
            }
        }
        // Step 4: Extract the k most frequent strings
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Map.Entry<String, Integer> entry = minHeap.poll();
            System.out.println(entry.getKey() +" " + entry.getValue());
            result.add(entry.getKey());
        }

        // Reverse the result since the smallest element was at the top of the heap
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "apple", "orange", "banana", "apple", "kiwi", "banana", "orange"};
        int k = 2;

        List<String> mostFrequentStrings = findKMostFrequent(strings, 3);
        System.out.println(mostFrequentStrings);  // Output: [banana, apple]
    }
}
