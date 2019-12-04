package com.HackerRank.Algorithms;

import java.util.*;

/**
 * @author Manoj.Mohanan Nair
 * @Date 8/14/17
 */
public class Kill_Process {

    public static void main(String[] args){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
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
