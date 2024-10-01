package com.HackerRank.Algorithms;

import java.util.*;

/**
 * @author Manoj.Mohanan Nair
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
 * Each process only has one parent process, but may have one or more children processes.
 * This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process.
 *
 * All the PIDs will be distinct positive integers. We use two list of integers to represent a list of processes,
 * where the first list contains PID for each process and the second list contains the corresponding PPID.
 *
 * Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes
 * that will be killed in the end. You should assume that when a process is killed, all its children processes
 * will be killed. No order is required for the final answer.
 */
public class Kill_Process {

    public static void main(String[] args){
        List<Integer> pid = new ArrayList<Integer>(Arrays.asList(1, 3, 10, 5));
        List<Integer> ppid = new ArrayList<Integer>(Arrays.asList(3, 0, 5, 3));

        List<Integer> output = killProcess_bfs(pid, ppid, 5);
    }
    public static List < Integer > killProcess_leetcode(List < Integer > pid, List < Integer > ppid, int kill) {

        HashMap < Integer, List < Integer >> leetmap = new HashMap<Integer, List < Integer >>();

        int ppidsize =  ppid.size();

        for (int i = 0; i < ppidsize; i++) {
            if (ppid.get(i) > 0) {
                List < Integer > l = leetmap.getOrDefault(ppid.get(i), new ArrayList < Integer > ());
                l.add(pid.get(i));
                leetmap.put(ppid.get(i), l);
            }
        }
        List < Integer > l = new ArrayList < > ();
        l.add(kill);
        getAllChildren(leetmap, l, kill);
        return l;
    }
    public static void getAllChildren(HashMap < Integer, List < Integer >> map, List < Integer > l, int kill) {
        if (map.containsKey(kill))
            for (int id: map.get(kill)) {
                l.add(id);
                getAllChildren(map, l, id);
            }
    }

    public static List<Integer> killProcess_bfs(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> ret = new ArrayList<Integer>();
        // hmap
        // key:ppid
        // value : pid list
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        for (int i=0; i<ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List<Integer> group = hmap.getOrDefault(ppid.get(i), new ArrayList<Integer>());
                group.add(pid.get(i));
                hmap.put(ppid.get(i), group); // note in python "setdefault" does this automatically
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (queue.size() != 0) {
            int node = queue.poll();
            ret.add(node);
            if (hmap.containsKey(node)) {
                for (int child : hmap.get(node)) {
                    queue.add(child);
                }
            }
        }
        return ret;
    }

    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++){
            map.computeIfAbsent(ppid.get(i), k -> new ArrayList<Integer>()).add(pid.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()){
            int target = queue.poll();
            ans.add(target);
            if (map.containsKey(target)){
                List<Integer> tmp = map.get(target);
                for (int num : tmp){
                    queue.offer(num);
                }
            }
        }
        return ans;
    }


}
