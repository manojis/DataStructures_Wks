package com.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Manoj.Mohanan Nair on 7/12/2017.
 */
public class ZeroSumChallenge {

    private void zeroSum(int[] iArr) {

        int sum = 0;
        int length = iArr.length;

        Arrays.sort(iArr);

        for (int i = 0; i < length - 2; i++) {

            int j = i + 1;
            int k = length - 1;

            while (j < k) {
                sum = iArr[i] + iArr[j] + iArr[k];
                if (sum == 0) {
                    System.out.println(iArr[i] + " " + iArr[j] + " " + iArr[k]);
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
    }

    public static void main(String[] args) throws java.lang.Exception {

        int[] arr = new int[]{2, 3, 6, -1, -4, 0, 1};
        ZeroSumChallenge code = new ZeroSumChallenge();
        code.zeroSum(arr);

    }
}
