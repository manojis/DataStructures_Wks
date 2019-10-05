package com.leetcode;

/**
 * where each person wendy can remove 'w', from between two w fields
 * and bob can remove 'b' from between two b fields
 * the person who does last wins the game
 *
 * Asked in volkswagen online interview
 */

/**public class GameWinner {
    public static void main(String[] args){
        String output = gameWinner("wwwbb");
        System.out.println(output);
    }

    public static String gameWinner(String colors){
        String winner = "";

        while(true){
            String wendy = finalWord('w',colors);
            if(wendy.length() == colors.length()){
                winner = "Bob";
                break;
            }
            colors = wendy;
            String Bob = finalWord('b',colors);
            if(Bob.length() == colors.length()){
                winner = "Wendy";
                break;
            }
            colors = Bob;
        }
        return winner;
    }

    public static String finalWord(char temp, String input){

        StringBuilder sb = new StringBuilder();
        boolean status = false;

        for(int i=0; i < input.length(); i++){
            sb.append(input.charAt(i));
            if(!status && (i < input.length()-2)
                    && (input.charAt(i) == temp)
                    && (input.charAt(i+1) == temp)
                    && (input.charAt(i+2) == temp)){
                sb.append(input.charAt(i));
                i = i+2;
                status = true;
                continue;
            }
        }
        return sb.toString();
    }
}*/
