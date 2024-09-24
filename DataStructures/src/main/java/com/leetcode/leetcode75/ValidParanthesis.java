package com.leetcode.leetcode75;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {
  public static void main(String[] args) {
    System.out.println(new ValidParanthesis().isValid("({{{{}}}))"));
  }

  public boolean isValid(String s) {
    HashMap<Character, Character> braces = new HashMap<>();
    braces.put(']','[');
    braces.put('}','{');
    braces.put(')','(');

    Stack<Character> stack = new Stack<>();
    boolean isValid = false;
    for(char in: s.toCharArray()) {
      if(!braces.containsKey(in)) {
        stack.push(in);
      } else {
        if(stack.empty()){
          return false;
        }
        if (braces.get(in).equals(stack.pop())) {
          isValid = true;
        } else {
          return false;
        }
      }
    }
    if (stack.isEmpty()) {
      return isValid;
    } else {
      return false;
    }
  }

}
