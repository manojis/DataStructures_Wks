package com.Misc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

    /**
     * @author Manoj.Mohanan Nair
     */
    public static void main(String[] args) {
        // create hash map
        HashMap<Integer,String> newmap = new HashMap();
        //newmap.
        // populate hash map
        newmap.put(1, "tutorials");
        newmap.put(2, "point");
        newmap.put(3, "is best");

        for (HashMap.Entry<Integer, String> entry : newmap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
        }
        Iterator<Integer> iter = newmap.keySet().iterator();

        while(iter.hasNext()){
            Integer keyVal = iter.next();
            String value = newmap.get(keyVal);
            System.out.println("Key set values are: " + value);
        }
    }
}
