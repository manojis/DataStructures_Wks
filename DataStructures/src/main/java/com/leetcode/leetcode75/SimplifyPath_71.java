package com.leetcode.leetcode75;

import java.util.Stack;

public class SimplifyPath_71 {
    public static void main(String[] args) {
        String input = "/home/user/Documents//../Pictures/";
        String[] arrInput = input.split("/");
        System.out.println(simplifyPath(input));
    }

    /**
     * @param path
     * @return
     */
    public static String simplifyPath(String path) {
        // with only strings having dots as well
        String [] arrInput = path.split("/");
        Stack<String> stack = new Stack<>();
        stack.push("/");

        for (int i = 0; i< arrInput.length; i++) {
            // if the first string is null or one of the string is .
            if (arrInput[i].equals("..") && stack.size()>1) {
                // we remove the last added string along with '/'(check on this)
                stack.pop();
                stack.pop();
            } else if(arrInput[i].equals("") || arrInput[i].equals(".") || arrInput[i].equals("..")) {
                continue;
            }  else {
                stack.push(arrInput[i]);
                stack.push("/");
            }
        }

        // reversing to get the right path
        Stack<String> reverse = new Stack();
        if (stack.size()>1) {
            stack.pop();
        }

        int length = stack.size();

        // dont use stack.size() in a for loop accidentally.

        for (int j=0;j<length;j++) {
            String temp = stack.pop();
            reverse.push(temp);
        }
        // adding to final stringBuilder
        StringBuilder result = new StringBuilder();
        length = reverse.size();

        // dont use stack.size() in a for loop accidentally;

        for(int x = 0; x< length; x++) {
            String temp = reverse.pop();
            result.append(temp);
        }
        return result.toString();
    }
}
