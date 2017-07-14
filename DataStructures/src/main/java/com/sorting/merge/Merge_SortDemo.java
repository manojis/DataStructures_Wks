/**
 * 
 */
package com.sorting.merge;

import java.util.Arrays;
import com.sorting.ArrayUtil;

/**
 * @author Manoj.Mohanan Nair *
 *    This program demonstrates the com.selection.merge sort algorithm by
 *    selection an array that is filled with random numbers. *
 */
public class Merge_SortDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = ArrayUtil.randomIntArray(10, 100);
		System.out.println(Arrays.toString(a));
		MergeSorter sorter = new MergeSorter(a);
		sorter.sort();
		System.out.println(Arrays.toString(a));
	}
}
