package com.HackerRank.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Manoj.Mohanan Nair
 * @Date 8/13/17
 * Input:
    ["Shogun", "Tapioca Express", "Burger King", "KFC"]
    ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
    Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 */
public class Min_Index_Sum_Lists {

    public static void main(String[] args){
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"KFC", "Shogun", "Burger King"};

        String[] result = findRestaurant(list1,list2);
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String,Integer> hMap = new HashMap<String,Integer>();
        ArrayList<String> aList = new ArrayList<String>();

        int count =0;
        for(String fList: list1){
            hMap.put(fList,count);
            count++;
        }
        int i=0;
        int curr_low = 2000;
        for(String fList2:list2) {
            if(!hMap.isEmpty() && hMap.containsKey(fList2)){
                int total_freq = hMap.get(fList2)+i;
                hMap.put(fList2,total_freq);

                if(curr_low > total_freq){
                    curr_low=total_freq;
                    aList.clear();
                    aList.add(fList2);
                    System.out.println("curr_low:"+curr_low);
                } else if(curr_low == total_freq){
                    curr_low=total_freq;
                    aList.add(fList2);
                }
            }
            i++;
        }
        String[] output = new String[aList.size()];
        output = aList.toArray(output);
        for(String val: output){
            System.out.println("output:"+val);
        }
        return output;
    }
}
