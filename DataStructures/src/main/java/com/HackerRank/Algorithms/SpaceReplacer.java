package com.HackerRank.Algorithms;

/**
 * Created by Manoj.Mohanan Nair on 5/26/2017.
 */
public class SpaceReplacer {

    public static void main(String[] args) {
        // your code goes here
        SpaceReplacer tst = new SpaceReplacer();
        String test = "we will exchange the total number of char with %20   ";
        char[] ch = test.toCharArray();
        //char[] ch = {'t', 'h', 'e', ' ', 'd', 'o', 'g', ' ', ' ', ' ', ' ', ' ', ' '};
        int length = 6;
        tst.replaceSpaces(ch, length);
    }

    public void replaceSpaces(char[] str, int length) {
        int spaceCount = 0, newLength = 0, i = 0;

        /*String test = "we will exchange the total number of char with %20";
        char[] str = test.toCharArray();
        int length = str.length;*/
        for (i = 0; i < length; i++) {
            if (str[i] == ' ')
                spaceCount++;
        }
        System.out.println(spaceCount);
        newLength = length + (spaceCount * 2);

        str[newLength] = '\0';
        for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
        System.out.println(str);
    }
}
