package com.CodeFights;

/**
 * @author Manoj.Mohanan Nair
 * @Date 7/26/18
 */
public class DeliveryInstacart {
    public static void main(String[] args){

        int[] order = {200,20,5};
        int[][] shoppers = {{300,40,5},
                {600,5,10},
                {200,20,5}};
        boolean[] rest = delivery(order,shoppers);
        System.out.println(rest);
    }

    public static boolean[] delivery(int[] order, int[][] shoppers) {

        boolean[] result = new boolean[shoppers.length];
        int length = shoppers.length;
        int order_time = order[1] + order[2];
        System.out.println(length);
        for(int i =0 ; i<shoppers.length; i++){

            int current_shopper_time = ((shoppers[i][0] + order[0]) /shoppers[i][1]) + shoppers[i][2];
            if(current_shopper_time < order_time && current_shopper_time > order[1] ){
                result[i] = true;
            }
        }
        return result;
    }
}
