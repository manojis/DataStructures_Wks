package com.HackerRank.Algorithms;

import java.io.*;
import java.util.*;
/**
 * @author Manoj.Mohanan Nair
 * @Date 8/12/17
 * input: as provided in the inputDict
 * output: difference in time for each function i.e 4,4,2,2seconds
 */


/**
 * Almoat clears all the test cases
 */
public class function_duration {

    public static void main (String[] args) throws java.lang.Exception
    {

        List<String> inputDict = new ArrayList<String>();
        /*inputDict.add("0:start:0");
        inputDict.add("1:start:2");
        //inputDict.add("2:start:3");
        //inputDict.add("2:end:5");
        //inputDict.add("3:start:7");
        //inputDict.add("3:end:9");
        inputDict.add("1:end:5");
        inputDict.add("0:end:6");*/

        inputDict.add("0:start:0");
        inputDict.add("0:end:0");
        inputDict.add("1:start:1");
        inputDict.add("1:end:1");
        inputDict.add("2:start:2");
        inputDict.add("2:end:2");
        inputDict.add("2:start:3");
        inputDict.add("2:end:3");


        int n =4;
        int[] output = exclusiveTime(n,inputDict);
        System.out.println(Arrays.toString(output));
     }

    public static int[] exclusiveTime(int n, List<String> logs) {

        Stack<Integer> id = new Stack<Integer>();
        Stack<Integer> time = new Stack<Integer>();
        int lengthz= 2*n;
        int j=0;

        String[] input = new String[lengthz];
        for(int i=0;i<lengthz;i++){
            input[i]= logs.get(i);
        }

        int[] output = new int[n];
        int z=0;
        int total=0;
        int totalIntervals=0;

        while(j<lengthz){
            String[] eachSet = input[j].split(":");

            if("start".equals(eachSet[1])){
                id.push(Integer.parseInt(eachSet[0]));
                time.push(Integer.parseInt(eachSet[2]));

            } else {

                int functionId = id.pop();
                int previous=0,startTime=0;
                int endTime = Integer.parseInt(eachSet[2])+1;

                if(!id.empty()){
                    previous = id.peek();
                }

                if(functionId==0 ||(!id.empty() && previous == functionId-1)){
                    startTime= (time.pop()) + totalIntervals;

                } else {
                    startTime= (time.pop());

                }
                total = endTime-startTime;
                output[z] = total;
                z++;
                totalIntervals = totalIntervals+total;
            }
            j++;
        }

        return output;
    }
}
