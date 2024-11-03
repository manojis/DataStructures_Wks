package com.Java_Experimentation;

import java.util.*;

public class customMapComparator {
    public static void main(String[] args) {
        // Sample HashMap
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("apple", 2);
        hashmap.put("banana", 1);
        hashmap.put("cherry", 3);
        hashmap.put("date", 2);
        hashmap.put("elderberry", 3);

        // Convert the HashMap to a List of Map entries
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashmap.entrySet());

        // Sort by value first, and then by key if values are the same
        list.sort(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed());

        list.sort(
                Comparator.comparing(Map.Entry<String, Integer>::getValue)
                        .reversed()
                .thenComparing(Map.Entry<String, Integer>::getKey));

        // Insert sorted entries into a LinkedHashMap to maintain order
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Display the sorted HashMap
        System.out.println("Sorted HashMap by values and keys: " + sortedMap);
    }
}
