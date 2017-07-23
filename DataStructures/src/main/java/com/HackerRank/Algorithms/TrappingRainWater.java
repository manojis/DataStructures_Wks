package com.HackerRank.Algorithms;

/**
 * Created by Mohitha on 7/23/2017.
 */
public class TrappingRainWater {

    public static void main(String[] args) {

        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = totalVolumeTrapped(input);
        System.out.println("Total volume of rainwater that can be trapped:" + result);

    }

    public static int totalVolumeTrapped(int[] input) {

        int totalVol = 0;

        int left = 0;
        int right = input.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        while (left <= right) {
            //Right has higher bar and hence left needs to get max value
            // to calculate the volume compared with right wall/bar
            if (input[left] <= input[right]) {
                //get the maxbar in the left side and difference of
                // maxbar and currentbar would give the volume of that bar
                if (input[left] >= maxLeft) {
                    maxLeft = input[left];
                } else {
                    totalVol = totalVol + (maxLeft - input[left]);
                }
                left++;
            } else {
                if (input[right] >= maxRight) {
                    maxRight = input[right];
                } else {
                    totalVol = totalVol + (maxRight - input[right]);
                }
                right--;
            }
        }
        return totalVol;
    }
}
