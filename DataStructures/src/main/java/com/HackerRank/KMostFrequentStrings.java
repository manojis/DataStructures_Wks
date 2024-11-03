package com.HackerRank;

import java.util.*;

public class KMostFrequentStrings {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequency = new HashMap<>();

        for (String st : words) {
            frequency.put(st, frequency.getOrDefault(st, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortList = new ArrayList<>(frequency.entrySet());

        sortList.sort(
                Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
                        .thenComparing(Map.Entry<String, Integer>::getKey));

        List<String> output = new ArrayList<String>();
        //Map<String, Integer> lHashMap = new LinkedHashMap<>();
        int i = 0;
        for (Map.Entry<String, Integer> entry : sortList) {
            if (i < k) {
                output.add(entry.getKey());
                i++;
            } else {
                break;
            }
        }
        return output;
    }

    public static List<String> findKMostFrequent(String[] strings, int k) {
        // Step 1: Count the frequency of each string
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : strings) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        // Step 2: Use a PriorityQueue to keep track of top k elements
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparing(Map.Entry<String, Integer>::getValue)
                        .thenComparing(Comparator.comparing(Map.Entry<String, Integer>::getKey).reversed()));

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
            result.add(entry.getKey());
        }

        // Reverse the result since the smallest element was at the top of the heap
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"i","love","leetcode","i","love","coding"};
        int k = 2;

        List<String> mostFrequentStrings = findKMostFrequent(strings, 2);
        List<String> mostFrequentStrs = topKFrequent(strings, 2);

        System.out.println(mostFrequentStrings);  // Output: [banana, apple]

        System.out.println("==============================");

        System.out.println(mostFrequentStrs);
    }
}
