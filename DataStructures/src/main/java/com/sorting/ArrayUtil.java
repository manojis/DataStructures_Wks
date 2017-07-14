/**
 * 
 */
package com.sorting;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Arrays;

/**
 * @author Manoj.Mohanan Nair
 *
 */
public class ArrayUtil {
	
	private static Random generator = new Random();
	private static final int SHORT_MAX = 65536;
	private static int counter = -1;

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
	public static synchronized long nextId() {
		if (counter == -1) {
			Random rnd = new SecureRandom();
			counter = rnd.nextInt(SHORT_MAX);
		}
		long now = System.currentTimeMillis();
		long id = (now << 16) | counter;
		counter = (counter + 1) % SHORT_MAX;
		return id;
	}

}
