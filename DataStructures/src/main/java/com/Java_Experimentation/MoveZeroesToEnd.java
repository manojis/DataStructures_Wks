package com.Java_Experimentation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.util.*;
import java.util.Map.Entry;

public class MoveZeroesToEnd {
    public static void moveZeroes() {
        int[] nums = {0, 1, 0, 3, 12};
        // Replace entire logic with lambda and stream operations
        // Move non-zero elements to the front and append zeros using lambdas and streams
        int[] result = IntStream.concat(
                IntStream.of(nums).filter(n -> n != 0),  // Move non-zero elements
                IntStream.generate(() -> 0)
                        .limit(Arrays.stream(nums)
                                .filter(n -> n == 0)
                                .count()))     // Append zeros
                .toArray();
        // Copy the result back to the original array
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    public static void FindNumbersStartingWithOne() {
        int[] numbers = {123, 456, 145, 789, 101, 19, 21};
        /**
         * if (String.valueOf(number).startsWith("1")) {
         *     result.add(number);  // Add the number to the result list
         * }
         */
        // Convert the array to a stream, then filter numbers starting with '1'
        List<Integer> result = Arrays.stream(numbers)
                .boxed()  // Convert IntStream to Stream<Integer>
                .filter(n -> String.valueOf(n).startsWith("1"))  // Check if the number starts with '1'
                .collect(Collectors.toList());  // Collect the results into a List

        // Print the resulting numbers
        System.out.println("Numbers starting with 1: " + result);
    }
    public static void sumEvenNum() {
        // Array of numbers
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(numbers).parallel().filter(n -> n %2 == 0).sum();
    }
    public static void main(String[] args) {
        //FindNumbersStartingWithOne();

        // Creating a sample HashMap
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 50);
        map.put("banana", 20);
        map.put("cherry", 50);
        map.put("date", 30);
        map.put("elderberry", 20);

        System.out.println("NOT SORTED: ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Sorting the HashMap by values and then by keys if values are the same
        Map<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Entry.<String, Integer>comparingByValue() // Sort by value
                        .thenComparing(Entry.comparingByKey()))  // If values are equal, sort by key lexicographically
                .collect(Collectors.toMap(
                        Entry::getKey,
                        Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));  // Collecting into a LinkedHashMap to maintain order

        // Printing the sorted map
        System.out.println("SORTED USING STREAMS : ");
        sortedMap.forEach((key, value) -> System.out.println(key + " : " + value));

        /**
         * WITHOUT USING STREAMS
         */
        // Create a List of Map entries
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Sort the list by value, then by key if values are the same
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                // First compare by value. change e1.getValue() and e2.getValue() based on whethere you want ASC or DESC
                int valueComparison = e2.getValue().compareTo(e1.getValue());
                // If values are the same, compare by key
                if (valueComparison == 0) {
                    //same here you want to change the ASC and DESC
                    return e2.getKey().compareTo(e1.getKey());
                }
                return valueComparison;
            }
        });

        // Put the sorted entries back into a LinkedHashMap to maintain the order
        Map<String, Integer> sortedMap_1 = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap_1.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted map
        System.out.println("SORTED: ");
        for (Map.Entry<String, Integer> entry : sortedMap_1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
