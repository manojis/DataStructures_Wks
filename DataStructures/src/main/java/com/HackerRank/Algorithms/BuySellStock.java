package com.HackerRank.Algorithms;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/10/2017
 */

public class BuySellStock {
    public static void main(String[] args){
        int[] input = new int[]{7, 1, 5, 3, 6, 4};
        int max = maxProfit(input);

        System.out.println("output is:"+max);
    }

    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
