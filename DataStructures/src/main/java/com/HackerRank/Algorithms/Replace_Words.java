package com.HackerRank.Algorithms;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Manoj.Mohanan Nair
 * @Date 8/12/17
 */
public class Replace_Words {

    public static void main(String[] args){

        int num = 4;
        ArrayList<String> output = new ArrayList<>();
        String inputStr = "asdfaiuhriquwhieruyqio";
        StringBuilder build = new StringBuilder();
        Set<Character> in = new HashSet<>();

        for(int i = 0;i<inputStr.length();i++){

            if(in.contains(inputStr.charAt(i))){
                in.remove(inputStr.charAt(i));
                in.add(inputStr.charAt(i));
            }else{
                in.add(inputStr.charAt(i));
            }

            if(in.size()==4){
                for(char k :in){
                    build.append(k);
                }

                output.add(String.valueOf(build));
                build = new StringBuilder();
                in = new HashSet<>();
                i=i+1-num;
                System.out.println("value: "+i);
            }

        }
        System.out.println(output);
    }


}
