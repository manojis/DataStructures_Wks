package com.algo6515.HW6515;

public class FrogJumpII {
    public static void main(String[] args){
        FrogJumpII x = new FrogJumpII();
        System.out.println("Final Value: "+ x.countPath());
    }
    public int countPath(){

        int[][] count = new int[17][17];
        for(int i=0;i<count.length;i++){
            count[i][0]=0;
            count[0][i]=0;
            count[i][1]=0;
            count[1][i]=0;
        }
        count[1][1]=1;
        for(int i=1;i<count.length;i++){
            for(int j=1;j<count.length;j++){
                if ((i-2 < 0) || (j-2 < 0)){
                    continue;
                }
                System.out.println((i-2) + ","+ (j-1) + "    "+ (i-1) + ","+ (j-2));
                count[i][j] = count[i-2][j-1] + count[i-1][j-2];
                System.out.println("fCount[i][j]: (" +i+","+j+") ->"+count[i][j]);
            }
        }
        return count[count.length-1][count.length-1];
    }
}
