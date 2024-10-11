package com.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.List;

public class ConnectedGroups {
    public static void main(String[] args) {
        // Example matrix of relationships
        int[][] relationships = {
                {1, 0, 1, 1, 0, 0},  // Person 0 knows person 0, 2, and 3
                {0, 1, 0, 0, 0, 0},  // Person 1 knows only themselves
                {1, 0, 1, 1, 0, 0},  // Person 2 knows person 0, 2, and 3
                {1, 0, 1, 1, 0, 0},  // Person 3 knows person 0, 2, and 3
                {0, 0, 0, 0, 1, 0},  // Person 4 knows only themselves
                {0, 0, 0, 0, 0, 1}   // Person 5 knows only themselves
        };
        List<String> input = new ArrayList<>(4);
        input.add("1100");
        input.add("1110");
        input.add("0110");
        input.add("0001");
        //input.add("000010");
        //input.add("000001");
        System.out.println("Number of groups: " + countGroups(input));
    }

    // Function to count the number of groups
    public static int countGroups(List<String> related) {// relationships
        int[][] relationships = new int[related.size()][related.get(0).length()];

        for (int i = 0; i < related.size(); i++) {
            String row = related.get(i);
            for (int j = 0; j < row.length(); j++) {
                relationships[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        // Print the 2D integer array to verify the output
        for (int i = 0; i < relationships.length; i++) {
            for (int j = 0; j < relationships[i].length; j++) {
                System.out.print(relationships[i][j] + " ");
            }
        }

        int n = relationships.length;
        boolean[] visited = new boolean[n];  // Track if a person has been visited
        int groupCount = 0;

        // Iterate through each person
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Perform DFS to mark all connected people
                dfs(relationships, visited, i);
                // After a DFS, we have found a complete group
                groupCount++;
            }
        }

        return groupCount;
    }

    // Depth-First Search to visit all connected people
    private static void dfs(int[][] relationships, boolean[] visited, int person) {
        visited[person] = true;  // Mark the person as visited

        // Check all other people
        for (int other = 0; other < relationships.length; other++) {
            // If there's a relationship and the other person hasn't been visited
            if (relationships[person][other] == 1 && !visited[other]) {
                // Recursively visit all connected people
                dfs(relationships, visited, other);
            }
        }
    }

}
