package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    // Function to perform DFS and topological sorting
    static void
    topologicalSortUtil(int currNode, List<List<Integer>> adj,
                        boolean[] visited,
                        Stack<Integer> stack) {
        // Mark the current node as visited
        visited[currNode] = true;

        // Recur for all adjacent vertices
        // adj would be like [[1],[2], , [3,2]],
        // hence for each of the index the adj list gives its neighbours which needs to be dfs'd
        for (int i : adj.get(currNode)) {
            if (!visited[i])
                topologicalSortUtil(i, adj, visited, stack);
        }
        // Push current vertex to stack which stores the
        // result
        stack.push(currNode);
    }

    // Function to perform Topological Sort
    static void topologicalSort(List<List<Integer>> adj, int V) {
        // Stack to store the result
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices one
        // by one
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, adj, visited, stack);
        }

        // Print contents of stack
        System.out.print(
                "Topological sorting of the graph: ");
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // Driver code
    public static void main(String[] args) {
        // Number of nodes
        int V = 4;

        // Edges
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(3, 1));
        edges.add(Arrays.asList(3, 2));

        // Graph represented as an adjacency list
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> i : edges) {
            adj.get(i.get(0)).add(i.get(1));
        }

        topologicalSort(adj, V);
    }
}
