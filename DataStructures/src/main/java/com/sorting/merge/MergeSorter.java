/**
 * 
 */
package com.sorting.merge;

/**
 * @author 212561694
 *This class sorts an array, using the com.selection.merge sort algorithm.
 */
public class MergeSorter {
	
	private int resultantArray[];
	MergeSorter(int anArray[]){
		resultantArray =  anArray;
	}
	/**
	Sorts the array managed by this com.selection.merge sorter.
 */
	 public void sort()
	 {
		if (resultantArray.length <= 1) return;
		int[] first = new int[resultantArray.length / 2];
		int[] second = new int[resultantArray.length - first.length];
		// Copy the first half of a into first, the second half into second
		for (int i = 0; i < first.length; i++) {
			first[i] = resultantArray[i];
		}
		for (int i = 0; i < second.length; i++)
		{
			second[i] = resultantArray[first.length + i];
		}
		 MergeSorter firstSorter = new MergeSorter(first);
		 MergeSorter secondSorter = new MergeSorter(second);
		 firstSorter.sort();
		 secondSorter.sort();
		 merge(first, second);
	 }

 /**
	  Merges two sorted arrays into the array managed by this com.selection.merge sorter.
	  @param first the first sorted array
	  @param second the second sorted array
 */
	 private void merge(int[] first, int[] second)
	 {
	   int iFirstArrayBegin = 0;  // Next element to consider in the first array
	   int iSecondArrayBegin = 0;  // Next element to consider in the second array
	   int iFirstArrayBeginArrayEnd = first.length;
	   int iSecondArrayBeginArrayEnd = second.length;
	   int resultArrayLocation = 0;  // Next open position in a
	
	   // As long as neither iFirstArrayBegin nor iSecondArrayBegin past the end, move
	   // the smaller element into  a

	   while (iFirstArrayBegin < iFirstArrayBeginArrayEnd && iSecondArrayBegin < iSecondArrayBeginArrayEnd )
	   {
	 	 if (first[iFirstArrayBegin] < second[iSecondArrayBegin])
	 	 {
	 		resultantArray[resultArrayLocation] = first[iFirstArrayBegin];
			iFirstArrayBegin++;
		 }
		 else
		 {
			 resultantArray[resultArrayLocation] = second[iSecondArrayBegin];
			iSecondArrayBegin++;
		 }
	 	resultArrayLocation++;
	   }
	
	   // Note that only one of the two loops below copies entries
	   // Copy any remaining entries of the first array
	   while (iFirstArrayBegin < iFirstArrayBeginArrayEnd)
	   {
		   resultantArray[resultArrayLocation] = first[iFirstArrayBegin];
		 iFirstArrayBegin++; 
		 resultArrayLocation++;
	   }
	   // Copy any remaining entries of the second half
	   while (iSecondArrayBegin < iSecondArrayBeginArrayEnd)
	   {
		   resultantArray[resultArrayLocation] = second[iSecondArrayBegin];
		 iSecondArrayBegin++; 
		 resultArrayLocation++;
	   }
	}
}
