package com.HackerRank.Algorithms;

import java.util.*;

/**
 * @author Manoj.Mohanan Nair
 * @Date 8/12/17
 */
public class Replace_Words {

    public static void main(String[] args){
        List<String> inputDict = new ArrayList<String>();
        inputDict.add("cat");
        inputDict.add("bat");
        inputDict.add("rat");
        inputDict.add("manoj");
        String sentence = "the cattle was rattled by the battery";
        replaceWords(inputDict,sentence);
    }

    public static String replaceWords(List<String> dict, String sentence) {

        if (dict == null || dict.size() == 0) return sentence;

        Set<String> set = new HashSet<>();
        for (String s : dict) set.add(s);

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");

        for (String word : words) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (set.contains(prefix)) break;
            }
            sb.append(" " + prefix);
        }

        return sb.deleteCharAt(0).toString();
    }
}
