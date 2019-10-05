package com.algo6515.dpv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dpv_6_4 {
    public static void main(String[] args){
        List<String> wordDict = new ArrayList<String>();
        /*wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        wordDict.add("test");
        String s = "catsandog";*/

        wordDict.add("apple");
        wordDict.add("pen");
        String s = "applepenapple";

        Dpv_6_4 x = new Dpv_6_4();
        System.out.println(x.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                System.out.println("Tword: "+ " "+ j + " "+ i + " "+ s.substring(j, i));
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    System.out.println("=========");
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
