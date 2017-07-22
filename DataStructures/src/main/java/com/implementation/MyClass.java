package com.implementation;

import com.interfaces.alpha;
import com.interfaces.beta;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Manoj.Mohanan Nair on 3/28/2017.
 */
public class MyClass implements alpha, beta {
    void display() {
        System.out.println("This is not default");
    }

    //@Override
    public void reset() {
        //alpha.super.reset();;
        System.out.println("Overridden");
        //Arrays.asList always gives only a list which is not modifiable
        List<String> list = Arrays.asList("manoj", "lam", "sreejith", "xyz");
        //to get a modifiable list, we need to Arraylist
        ArrayList<String> arr = new ArrayList<String>(list);
        HashSet<String> str = new HashSet<String>();
        str.
                Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                System.out.println("value is" + (b.compareTo(a)));
                return b.compareTo(a);
            }
        });
        System.out.println("list sort" + list);
        Collections.sort(arr);
    }

    public static void main(String args[]) {
        MyClass classs = new MyClass();
        classs.reset();
    }
}
