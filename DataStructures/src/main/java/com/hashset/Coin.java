package com.hashset;

/**
 * Created by 212561694 on 4/16/2017.
 */
public class Coin {
    private String name;
    private double val;

    public Coin(String name, double val) {
        this.name = name;
        this.val = val;
    }

    public void add(Coin coin) {

    }

    public int hashCode() {

        final int Hash_Multiplier = 29;
        int val1 = name.hashCode();
        if (val1 < 0)
            val1 = -val1;
        int val2 = new Double(val).hashCode();
        if (val2 < 0)
            val2 = -val2;
        int val = Hash_Multiplier * val1 + val2;
        if (val < 0)
            val = -val;
        return val;
    }
}
