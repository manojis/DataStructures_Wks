package com.Puzzles;

/**
 * Created by Manoj.Mohanan Nair on 3/23/2017.
 */
public class ParenthesisCheck {

    /*public static void main(String args[]) {
        String word = "(:()(";
        word = word.replaceAll("[a-zA-Z0-9]", "");
        System.out.println(word);
        ParenthesisCheck test1 = new ParenthesisCheck();
        boolean val = test1.isBalancedMessage(word);
    }*/

    public boolean isBalancedMessage(String word) {

        boolean isBalanced = true;
        int minOpen = 0;
        int maxOpen = 0;

        char[] wordChars = word.toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            if (wordChars[i] == '(') {
                maxOpen++;
                if (i > 0 && wordChars[i - 1] == ':') {
                    minOpen++;
                    //maxOpen --;
                }
            } else if (wordChars[i] == ')') {
                minOpen--;
                if (i > 0 && wordChars[i - 1] == ':') {
                    maxOpen--;
                    //minOpen ++;
                }
            }
            if (minOpen < 0)
                minOpen = 0;

            if (maxOpen < 0) {
                maxOpen = 0;
                break;
            }
        }
        //outside for loop
        if (minOpen != 0)
            isBalanced = false;
        if (maxOpen != 0)
            isBalanced = false;

        System.out.println(isBalanced);
        return isBalanced;
    }
}
