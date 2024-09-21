package com.leetcode.leetcode75;

import java.util.HashMap;

public class ValidAnagram {
  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";
    System.out.println(isAnagram(s, t));

  }
  public static boolean isAnagram(String s, String t) {
    HashMap<Character, Integer> map = new HashMap();
    char[] sInput = s.toCharArray();
    char[] tInput = t.toCharArray();
    for(char c: sInput) {
      if(map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c,1);
      }
    }
    boolean result = false;
    for(char d: tInput) {
      if(map.containsKey(d)) {
        result = true;
        Integer count = map.get(d);
        map.put(d, count - 1);
        if (map.get(d) == 0) {
          map.remove(d);
        }
      } else {
        result = false;
      }
    }
    if (map.isEmpty() && result) {
      return true;
    }
    return false;
  }

}
