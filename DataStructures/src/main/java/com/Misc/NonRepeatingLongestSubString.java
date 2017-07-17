package com.Misc;

import java.util.HashMap;

/**
 * Created by Manoj.Mohanan Nair on 7/13/2017.
 */
public class NonRepeatingLongestSubString {


    public static void main(String[] args) throws java.lang.Exception {
        String input = "PWWKEW";
        NonRepeatingLongestSubString code = new NonRepeatingLongestSubString();
        System.out.println("value of" + code.maxCount(input));
    }

    private int maxCount(String input) {

        int currentMaxCount = 0;
        int maxCount = 0;
        int size = input.length();

        try {
            HashMap<Integer, Boolean> hMap = new HashMap<Integer, Boolean>();
            int i = 0;
            while (i < size) {
                int hashValue = new Character(input.charAt(i)).hashCode();

                if (!hMap.containsKey(hashValue) && null == hMap.get(hashValue)) {
                    hMap.put(hashValue, true);
                    i++;
                    currentMaxCount++;

                } else {
                    if (currentMaxCount > maxCount) {
                        maxCount = currentMaxCount;
                    }
                    hMap.clear();
                    currentMaxCount = 0;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return maxCount;
    }
}
