/**
 * 
 */
package com.sorting;

import java.util.Random;
import java.util.Arrays;

/**
 * @author 212561694
 *
 */
public class ArrayUtil {
	
	private static Random generator = new Random();
	
	public static int[] randomIntArray(int len, int range){
		int a[] = new int[len];
		for(int i=0;i<a.length;i++){
			a[i] = generator.nextInt(range);
		}
		System.out.println(Arrays.toString(a));
		return a;
		
	}
	
	public static int[] getArray(){
		int size=10;
		int []array = new int[size];
		int item = 0;
		for(int i=0;i<size;i++){
			item = (int)(Math.random()*100); 
			array[i] = item;
		}
		return array;
	}
	
	public static void printArray(int[] a){
		for(int i : a){
			System.out.print(i+" ");
		}
	}

}
