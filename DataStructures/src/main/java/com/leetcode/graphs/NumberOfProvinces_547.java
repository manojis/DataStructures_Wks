package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfProvinces_547 {
    public static void main(String[] args) {
        NumberOfProvinces_547 ls = new NumberOfProvinces_547();
        int[][] input = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(ls.findCircleNum_1(input));
        System.out.println(ls.findCircleNum_2(input));
    }

    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] seen;

    /**
     * Simpler Approach
     * @return
     */
    public int findCircleNum_1(int[][] isConnected) {

        int n = isConnected.length;
        int ccnum = 0;
        boolean[] bConnected = new boolean[n];

        for (int i = 0; i< n; i++) {
            if (!bConnected[i]) {
                ccnum++;
                connectedComponents(bConnected, isConnected, i);
            }
        }
        return ccnum;
    }

    public void connectedComponents(boolean[] bConnected, int[][] isConnected, int currNode) {
        for (int i = 0; i<isConnected[currNode].length; i++) {

            bConnected[currNode] = true;
            if (isConnected[currNode][i] == 1 && currNode != i && !bConnected[i]) {
                connectedComponents(bConnected, isConnected, i);
            }
        }
    }

    /**
     * Another approach Below
     * @param isConnected
     * @return
     */
    public int findCircleNum_2(int[][] isConnected) {
        // build the graph
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
            }
            for (int j = i + 1; j < n; j++) {
                if (!graph.containsKey(j)) {
                    graph.put(j, new ArrayList<>());
                }
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        seen = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                // add all nodes of a connected component to the set
                ans++;
                seen[i] = true;
                dfs(i);
            }
        }

        return ans;
    }

    public void dfs(int node) {
        for (int neighbor: graph.get(node)) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                dfs(neighbor);
            }
        }
    }
}
