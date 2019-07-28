package com.Java_Experimentation.threads;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/25/19
 */
public class NameList {

    private List<String> names = Collections.synchronizedList(new LinkedList<String>());

    public synchronized void add(String name){
        names.add(name);
    }

    public synchronized String removeFirst(){
        if(names.size()>0){
            return (String)names.remove(0);
        }else {
            return null;
        }
    }

    public static void main(String[] args){
        final NameList nls = new NameList();
        nls.add("manoj");

        class NameTest extends Thread {
            public void run() {
                String name = nls.removeFirst();
                System.out.println("tested: " + name);
            }
        }
        Thread t1 = new NameTest();
        Thread t2 = new NameTest();
        t1.start();
        t2.start();
    }
}
