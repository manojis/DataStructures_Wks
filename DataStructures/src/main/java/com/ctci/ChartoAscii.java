package com.ctci;

import org.apache.hadoop.mapreduce.FileSystemCounter;

import javax.xml.transform.stream.StreamSource;
import java.util.Arrays;

public class ChartoAscii {
    public static void main(String[] args){
        char x = 'b';
        System.out.println("value: "+(int)x);
        int[] xd = new int[256];
        for(int xe : xd){
            System.out.println(xe);
        }
    }
}
