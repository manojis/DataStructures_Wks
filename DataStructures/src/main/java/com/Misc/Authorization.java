
package com.Misc;


/**
 * Created by 212561694 on 12/18/2016.
 */

public class Authorization {

    public static void main(String[] args)
    {
        String val = "interviewwithyahoo";
        String reverse = "";
        int valLength = val.length();
        for(int i = (valLength-1); i>=0;i--)
        {
            reverse = reverse + val.charAt(i);
            System.out.print(reverse);
        }
    }
}

