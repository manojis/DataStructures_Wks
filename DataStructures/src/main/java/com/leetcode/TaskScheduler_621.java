package com.leetcode;

import java.util.*;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        // Edge case: if there is no cooling period, return the length of the tasks array
        if (n == 0) return tasks.length;

        // Step 1: Count the frequency of each task
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }

        // Step 2: Use a priority queue to always process the most frequent task first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : taskCounts) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }

        // Step 3: Simulate the task execution with a cooling period
        int intervals = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int time = 0;

            // Process up to n + 1 tasks in each cycle
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    tempList.add(maxHeap.poll());
                    time++;
                }
            }

            // Decrease the frequency of tasks and re-add them to the heap if they still have remaining executions
            for (int count : tempList) {
                if (count - 1 > 0) {
                    maxHeap.add(count - 1);
                }
            }

            // If the heap is empty, all tasks are completed; otherwise, count the full (n + 1) interval
            if (maxHeap.isEmpty()) {
                intervals += time;
            } else {
                intervals += (n + 1);
            }
        }

        return intervals;
    }

    public static void main(String[] args) {
        TaskScheduler_621 scheduler = new TaskScheduler_621();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println("Least intervals needed: " + scheduler.leastInterval(tasks, n)); // Output: 8
    }
}
