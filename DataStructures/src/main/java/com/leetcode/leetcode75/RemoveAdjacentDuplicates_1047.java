package com.leetcode.leetcode75;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RemoveAdjacentDuplicates_1047 {
  public static void main(String[] args) {
    RemoveAdjacentDuplicates_1047 removeAdjacentDuplicates = new RemoveAdjacentDuplicates_1047();
    System.out.println(removeAdjacentDuplicates.removeDuplicates("azxxzy"));
  }
  public String removeDuplicates(String s) {
    // we can either use two stacks. one for pushing and pop and checking.
    // second one for reversing the whole string
    Stack<Character> stack = new Stack<>();
    for(char ch: s.toCharArray()) {
      // check if the char is already there, then pop them out
      if (!stack.empty() && stack.peek() != null && stack.peek().equals(ch)) {
        stack.pop();
      } else {
        stack.push(ch);
      }
    }
    /**
     * this is an important one you can use
     * String.valueOf(stack)
      */
    System.out.println(String.valueOf(stack));

    char[] result = new char[stack.size()];
    for(int i = stack.size()-1 ; i >= 0; i--) {
      result[i] = stack.pop();
    }
    return new String(result);

    // we can also char array completely. just go back to previous index and replace the char.
    // no need to use stringbuilder
  }
}
