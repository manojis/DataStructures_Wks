package com.ctci;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/6/19
 * Remove Duplicates from a list
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        LinkedList<String> uList = new LinkedList<String>();
        uList.add("Manoj");
        uList.add("Mohan");
        uList.add("Lalitha");
        uList.add("arya");
        uList.add("manvi");
        uList.add("Manoj");
        uList.add("manvi");

        Set<String> dSet = new HashSet<String>(uList);
        dSet.forEach(element -> System.out.println(element));
    }
}
