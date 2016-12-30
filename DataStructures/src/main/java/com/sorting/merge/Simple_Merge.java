/**
 * 
 */
package com.sorting.merge;

/**
 * @author 212561694
 *
 */
public class Simple_Merge {
	
	/*private int[] leftArray,rightArray;
	Simple_Merge(int[] left,int[] right){
		leftArray=left;
		rightArray =right;
	}*/
	/*
     * A sample com.selection.merge method to help understand the com.selection.merge routine.
     * This below function is not used by the com.selection.merge sort
     *
     * This is here only for explanation purpose
     */
    public int[] sampleMerge(int[] leftArray, int[] rightArray) {

        int leftArrayEnd = leftArray.length - 1;
        int rightArrayEnd = rightArray.length - 1;
        int leftArrayBegin = 0;
        int rightArrayBegin = 0;

        int numElements = leftArray.length + rightArray.length;
        int[] resultArray = new int[numElements];
        int resultArrayBegin = 0;

        // Find the smallest element in both these array and add it to the temp
        // array i.e you may have a array of the form [1,5] [2,4]
        // We need to sort the above as [1,2,4,5]
        while (leftArrayBegin <= leftArrayEnd && rightArrayBegin <= rightArrayEnd) {
            if (leftArray[leftArrayBegin] <= rightArray[rightArrayBegin]) {
                resultArray[resultArrayBegin++] = leftArray[leftArrayBegin++];
            } else {
                resultArray[resultArrayBegin++] = rightArray[rightArrayBegin++];
            }
        }

        // After the main loop completed we may have few more elements in
        // left array so copy them
        while (leftArrayBegin <= leftArrayEnd) {
            resultArray[resultArrayBegin++] = leftArray[leftArrayBegin++];
        }

        // After the main loop completed we may have few more elements in
        // right array so copy them
        while (rightArrayBegin <= rightArrayEnd) {
            resultArray[resultArrayBegin++] = rightArray[rightArrayBegin++];
        }

        return resultArray;
    }

}
