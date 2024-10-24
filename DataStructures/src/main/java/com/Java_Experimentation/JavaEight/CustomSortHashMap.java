package com.Java_Experimentation.JavaEight;

import java.util.*;

public class CustomSortHashMap {

    public static void main(String[] args) {
        // Creating the HashMap with ID (Integer) and String values
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Banana");
        map.put(2, "Apple");
        map.put(3, "Orange");
        map.put(4, "Grapes");

        // Sorting the HashMap by the String values
        Map<Integer, String> sortedMap = sortByValue(map);

        // Printing the sorted HashMap
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    // Method to sort the HashMap by values (String)
    public static Map<Integer, String> sortByValue(HashMap<Integer, String> map) {
        System.out.println(map.entrySet());
        // Convert the HashMap to a list of Map entries
        List<Map.Entry<Integer, String>> list = new LinkedList<>(map.entrySet());

        // Sort the list using a custom comparator (by the value of the strings)
        list.sort(Map.Entry.comparingByValue());

        // Create a LinkedHashMap to preserve the sorted order
        Map<Integer, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}

