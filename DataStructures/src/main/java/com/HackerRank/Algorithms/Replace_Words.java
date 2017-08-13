package com.HackerRank.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        String[] inputs = sentence.split(" ");
        String[] inpuzs = (String[]) dict.toArray();

        HashMap<Integer,String> hMap = new HashMap<Integer, String>();
        hMap.put(1,"cattle");


        return null;
    }
}
