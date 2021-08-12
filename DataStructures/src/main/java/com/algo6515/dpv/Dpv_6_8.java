package com.algo6515.dpv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Not sure of this answer if its part of DP. Need to check later by verifying with udacity lecture
 */
public class Dpv_6_8 {

    public static void main(String[] args){
        List<String> wordDict = new ArrayList<String>();
        int [] x = {1,2,3,2,1};
        int [] y = {3,2,1,4,7};

        Dpv_6_8 v = new Dpv_6_8();
        System.out.println(v.findLength(x, y));
    }

    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
    }

}
