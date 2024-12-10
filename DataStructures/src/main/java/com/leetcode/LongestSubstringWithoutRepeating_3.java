package com.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestSubstringWithoutRepeating_3 {
    public static void main(String[] args) {
        String input = "pwwkew";
        int result = lengthOfLongestSubstring(input);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        // use a combination of sliding window and hashset
        // if the char is there in the hashset move the sliding window in the back by 1 and remove the first char from hashset
        // else move the sliding window in the front by 1 and add that char to hashset

        // checked stackoverflow for using streams and lambda
        List<Character> list = s.chars().mapToObj(i -> Character.valueOf((char)i)).collect(Collectors.toList());
        Set<Character> hSet = new HashSet<>();
        int maxLength = 0;
        int tempMax = 0;

        if(list.size() == 0) {
            return 0;
        }
        // pwwkew
        int i = 0;
        for(int j=0; j<list.size();) {
            char tempChar = list.get(j);
            if(!hSet.contains(tempChar)) {
                hSet.add(tempChar);
                tempMax++;
                j++;
            } else {
                hSet = new HashSet<>();
                tempMax=0;
                i++;
                j=i;
            }
            maxLength = Math.max(tempMax, maxLength);
        }
        return maxLength;
    }
}
