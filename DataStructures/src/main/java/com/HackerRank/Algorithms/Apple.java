package com.HackerRank.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Manoj.Mohanan Nair on 7/25/2017.
 */
public class Apple {

    public static void main(String[] args) throws java.lang.Exception {

        try {
            int[] a1 = {2, 21, 6, 6, 9, 9, 13};
            int[] a2 = {3, 6, 9, 9, 9, 9, 13, 22, 21};

            ArrayList<Integer> result = intersectionValues(a1, a2);
            System.out.println(Arrays.toString(result.toArray()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static ArrayList<Integer> intersectionValues(int[] a1, int[] a2) {

        //Creating two Hashmaps and each HashMaps contains the value from the array     //and the frequency of the value in that hashmap.
        HashMap<Integer, Integer> hMap1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> hMap2 = new HashMap<Integer, Integer>();

        int count = 1;
        for (int i : a1) {
            if (hMap1 != null && hMap1.containsKey(i)) {
                count = hMap1.get(i);
                count++;
                hMap1.put(i, count);
            } else {
                hMap1.put(i, 1);
            }
        }
        count = 1;
        for (int j : a2) {
            if (hMap2 != null && hMap2.containsKey(j)) {
                count = hMap2.get(j);
                count++;
                hMap2.put(j, count);
            } else {
                hMap2.put(j, 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        int val = 0;
        for (Map.Entry<Integer, Integer> entry : hMap1.entrySet()) {
            int y = 0;
            if (hMap2.containsKey(entry.getKey())) {
                if (hMap2.get(entry.getKey()) >= entry.getValue()) {
                    val = entry.getValue();
                } else if (hMap2.get(entry.getKey()) < entry.getValue()) {
                    val = hMap2.get(entry.getKey());
                }
                while (y < val) {
                    result.add(entry.getKey());
                    y++;
                }
            }
        }
        return result;
    }
}
