/**
 * 
 */
package com.merge;

import java.util.Arrays;
import com.selection.ArrayUtil;

/**
 * @author 212561694 *
 *    This program demonstrates the com.merge sort algorithm by
 *    sorting an array that is filled with random numbers. *
 */
public class Merge_SortDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = ArrayUtil.randomIntArray(20, 100);
		System.out.println(Arrays.toString(a));
		MergeSorter sorter = new MergeSorter(a);
		sorter.sort();
		System.out.println(Arrays.toString(a));
	}
}
