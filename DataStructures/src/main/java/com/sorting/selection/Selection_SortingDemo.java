/**
 * 
 */
package com.sorting.selection;

import com.sorting.ArrayUtil;

/**
 * @author Manoj.Mohanan Nair
 *
 */
public class Selection_SortingDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = ArrayUtil.randomIntArray(20,100);
		Selection_Sorter sorter = new Selection_Sorter(a);
		sorter.sort();
	}
}
