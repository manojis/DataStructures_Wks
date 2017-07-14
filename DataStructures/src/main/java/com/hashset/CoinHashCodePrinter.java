package com.hashset;

import java.util.HashSet;

/**
 * Created by Manoj.Mohanan Nair on 4/16/2017.
 */
public class CoinHashCodePrinter {

    public static void main(String[] args) {

        Coin coin1 = new Coin("coin1", 0.25);
        Coin coin2 = new Coin("coin2", 0.75);
        Coin coin3 = new Coin("coin3", 0.50);
        coin1.hashCode();
        coin2.hashCode();
        coin3.hashCode();
        System.out.println(coin1.hashCode() + "  " + coin2.hashCode() + "  " + coin3.hashCode());
        HashSet<Coin> coinSet = new HashSet<Coin>();
        coinSet.add(coin1);
        coinSet.add(coin2);
        coinSet.add(coin3);

        for (Coin s : coinSet) {
            System.out.println(s.hashCode());
        }
    }

}
