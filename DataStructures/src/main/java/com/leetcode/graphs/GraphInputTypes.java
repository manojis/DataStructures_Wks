package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphInputTypes {
    public static void main(String[] args) {
        int[][] input = {{0, 1}, {1, 2}, {2, 0}, {2, 3}};
        Map<Integer, List<Integer>> output = buildGraph(input);
        for (Map.Entry<Integer, List<Integer>> entry : output.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    /**
     * Second input format: Adjacency list
     */
    public static void buildAdjacencyList() {

    }

    /**
     * First input format: array of edges
     * @param edges
     * @return Map<Integer, List<Integer>>
     */
    public static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            if (graph.containsKey(x)) {
                graph.get(x).add(y);
            } else {
                List temp = new ArrayList<Integer>();
                temp.add(y);
                graph.put(x, temp);
            }
        }
        return graph;
    }
}
