package com.HackerRank.Algorithms;

/**
 * @author Manoj.Mohanan Nair
 * @Date 8/15/17
 */
public class Judge_Route_Circle {
    public static void main (String[] args) throws java.lang.Exception
    {
        String moves = "LULDURDR";
        boolean result = judgeCircle(moves);

        System.out.println("result: " +result);
    }

    public static boolean judgeCircle(String moves) {

        moves=" " + moves + " ";

        if((moves.split("L").length) == (moves.split("R").length) &&
                (moves.split("U").length) == (moves.split("D").length)){
            return true;
        }else{
            return false;
        }

    }

    public static boolean mine_judgeCircle(String moves) {

        int length = moves.length();
        if(length==0 || moves==null){
            return false;
        }
        char[] lchar= new char[length];
        int sCount =0;
        int uCount =0;

        for(int i=0;i<length;i++){
            lchar[i]= moves.charAt(i);

            if(lchar[i]=='L'){
                sCount++;
            }else if(lchar[i] == 'R'){
                sCount--;
            } else if(lchar[i] == 'U'){
                uCount++;
            } else if(lchar[i] == 'D'){
                uCount--;
            }
        }

        if(sCount==0 && uCount==0){
            return true;
        }else {
            return false;
        }
    }
}
