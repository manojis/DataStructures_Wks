package com.HackerRank.Algorithms;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/10/2017
 */

public class BuySellStock_121_122 {
    public static void main(String[] args){
        int[] input = new int[]{7, 2, 9, 1, 5, 3, 6, 4};
        int[] input_1 = new int[]{1,7,2,3,6,7,6,7};

        System.out.println("output is:"+maxProfit_121(input));
        System.out.println("output of maxSumprofit is:"+ maxSumProfit_122(input_1));
    }

    public static int maxProfit_121(int prices[]) {
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

    public static int maxSumProfit_122(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }
}
