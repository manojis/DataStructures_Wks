package com.leetcode.leetcode75;

import java.io.*;

public class KRadiusSubarrayAverage_2090 {
    public static void main(String[] args) throws FileNotFoundException {
        KRadiusSubarrayAverage_2090 in = new KRadiusSubarrayAverage_2090();
        String filePath= "src/main/java/com/leetcode/leetcode75/test.txt";

        // Variable to store the numbers from the file
        int[] numbers = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the first (and only) line
            String line = br.readLine();
            // Split the line by commas to get the individual numbers as strings
            String[] stringNumbers = line.split(",");
            // Initialize the array to hold the integers
            numbers = new int[stringNumbers.length];
            // Convert the string numbers to integers and store them in the array
            for (int i = 0; i < stringNumbers.length; i++) {
                numbers[i] = Integer.parseInt(stringNumbers[i].trim());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        in.getAverages(numbers, 4000);
    }

    public int[] getAverages(int[] nums, int k) {
        // find the cumulative sum for each of the indices
        int length = nums.length;
        int[] output = new int[length];
        int[] cumSum = new int[length];
        cumSum[0] = nums[0];

        for(int i=1; i<length; i++) {
            cumSum[i] = cumSum[i-1]+nums[i];
        }
        // 7, 4,   3,  9, 1,  8,  5,  2,  6
        // 7, 11, 14, 23, 24, 32, 37, 39, 45

        for (int i=0; i<length; i++) {
            // if i<k or (length-i) <k, update -1 for that index
            if(i<k || ((length-1)-i)<k){
                output[i] = -1;
            } else {
                // find the subarray sum = sum at index i+k - (i-k-1)
                // if (i-k-1) is less than zero then keep the value as zero
                int prefixSum = 0;
                if ((i-k-1)>=0) {
                    prefixSum = cumSum[i-k-1];
                }
                output[i] = (cumSum[i+k]-prefixSum)/7;
            }
        }
        return output;
    }
}
