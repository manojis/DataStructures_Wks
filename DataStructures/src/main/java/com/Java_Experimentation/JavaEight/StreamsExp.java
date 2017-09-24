package com.Java_Experimentation.JavaEight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/20/17
 */
public class StreamsExp {

    public static void main(String[] args){
        List<String> output = new ArrayList<String>();
        output.add("asfda");
        output.add("asfdsa");
        output.add("awsfda");
        output.add("aswufda");
        Stream<String> streamz = output.stream();

        Iterator<String> iter= output.iterator();
        while(iter.hasNext()){
            System.out.println("value from iter:" +iter.next());
        }

    }
}
