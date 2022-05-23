/**
 * 
 */
package com.leetcode.dynamic;

/**
 * @author Manoj
 *
 */
public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        int[] input = new int[]{2,3,1,1,4};
        //int[] input = new int[]{3,2,1,0,4};
        boolean output = canJump(input);
        System.out.println(output);
	}
	
	/**
	 * 
	 * @param nums
	 * Basically we are looping from the end to the first and assigning a distance value in an array
	 *  and also setting a status. if the distance is greater than the current index value, then 
	 *  increase the distance by 1, since the i-1 value needs one extra value to reach the end.
	 *  finally if the first index has status 1, then its true else false
	 * @return
	 */
			
public static boolean canJump(int[] nums) {
        
        int[] distance = new int[nums.length];
        int[] status = new int[nums.length];
        distance[nums.length-1] = 1;
        status[nums.length-1] = 1;
         
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i] >= (distance[i+1])) {
                distance[i] = 1;
                status[i] = 1;
            } else {
                distance[i] = distance[i+1]+1;
                status[i] = 0;
            }            
        }
        
        if(status[0]==1){
            return true;
        }else {
            return false;
        }
        
    }

}
