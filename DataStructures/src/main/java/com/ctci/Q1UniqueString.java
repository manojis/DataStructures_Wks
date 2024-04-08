package com.ctci;

public class Q1UniqueString {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        boolean val = uniqueString("tesing");
        System.out.println(val);
    }
    private static boolean uniqueString(String word) {
        boolean uniqueString = true;
        int len = word.length();
        // Get each of the characters and verify if the same character exists after that char index.
        for (int i=0; i<len; i++) {
            char c = word.charAt(i);
            for(int j = i+1; j<len; j++) {
                if (word.charAt(j) == word.charAt(i)) {
                    uniqueString = false;
                    break;
                }
            }
            if (!uniqueString) {
                break;
            }
        }
        return uniqueString;
    }
}
