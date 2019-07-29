package com.Java_Experimentation.JavaEight;

import java.util.HashMap;

public class modulo {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int rem = 23 % 7;
        String x = "Sat";
        modulo xu = new modulo();
        String output = xu.calc(x, rem);
        System.out.println(output);
    }
    public String calc(String S, int K){
        HashMap<String,Integer> intweekdays = new HashMap<String,Integer>();
        intweekdays.put("Mon", 1);
        intweekdays.put("Tue", 2);
        intweekdays.put("Wed", 3);
        intweekdays.put("Thu", 4);
        intweekdays.put("Fri", 5);
        intweekdays.put("Sat", 6);
        intweekdays.put("Sun", 7);
        int currentIndex = intweekdays.get(S);
        int finalIndex = currentIndex + K;
        if(finalIndex > 7 ) {
            finalIndex = finalIndex % 7;
        }
        String out = "";
        System.out.println("finalIndex "+ finalIndex);
        for (String output : intweekdays.keySet()) {
            if (intweekdays.get(output).equals(K)) {
                System.out.println("value "+ output);
                out = output;
            }
        }
        return out;
    }
}
