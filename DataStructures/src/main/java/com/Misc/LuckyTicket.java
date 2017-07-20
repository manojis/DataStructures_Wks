package com.Misc;

/**
 * Created by Mohitha on 7/19/2017.
 */

import java.util.*;

public class LuckyTicket {

    //fails in one test case

    static String onceInATram(int x) {
        // Complete this function

        int count = 0;
        int first = Integer.parseInt(String.valueOf(x).substring(0, 3));
        int firstCopy = first;
        int last = Integer.parseInt(String.valueOf(x).substring(3, 6));
        int lastCopy = last;
        int sumFirst = 0;
        int sumLast = 0;
        int i = 0;

        if (firstCopy > 0) {
            while (i < 3) {
                int rem = firstCopy % 10;
                sumFirst = sumFirst + rem;
                firstCopy = firstCopy / 10;
                i++;
            }
        }

        if (last > 0) {
            i = 0;
            while (i < 3) {
                int rem = lastCopy % 10;
                sumLast = sumLast + rem;
                lastCopy = lastCopy / 10;
                System.out.println(sumLast);
                i++;
            }
            if (sumFirst > sumLast) {
                last = last + (sumFirst - sumLast);
            } else if (sumFirst == sumLast) {
                last = last + 9;
            } else {
                last = last + (9 - (sumLast - sumFirst));
            }
        } else {
            last = last + sumFirst;
        }
        String result = String.valueOf(first) + String.valueOf(last);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        String result = onceInATram(x);
        System.out.println(result);
    }
}

