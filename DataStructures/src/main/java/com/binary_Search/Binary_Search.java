/**
 * 
 */
package com.binary_Search;

/**
 * @author Manoj.Mohanan Nair
 *
 */

import com.sorting.ArrayUtil;

/**
A class for executing binary searches through an array.
*/
public class Binary_Search
{
    private int[] a;
/**
   Constructs a BinarySearcher.
    @param anArray a sorted array of integers
 */
 public Binary_Search(int[] anArray)
 {
    a = anArray;
 }

 /**
    Finds a value in a sorted array, using the binary
    search algorithm.
    @param v the value to search
    @return the index at which the value occurs, or -1
    if it does not occur in the array
 */
 public int search(int v)
 {
    //Arrays needs to be in sorted order
    int low = 0;
    int high = a.length - 1;
    System.out.println("Value searched is:" +v);
    while (low <= high)
    {
       int mid = (low + high) / 2;
       int diff = a[mid] - v;

       if (diff == 0) // a[mid] == v
          return mid;
       else if (diff < 0) // a[mid] < v
          low = mid + 1;
       else
           high = mid - 1;
    }
      return -1;
 }
 public static void main(String[] args)
   {
     int[] arr = ArrayUtil.randomIntArray(10,100);
     Binary_Search searchVal = new Binary_Search(arr);
     int searchForVal = arr[6];
     //int searchForVal = 6;
     int result = searchVal.search(searchForVal);
     if(result<0){
         System.out.println("Found");
     }
     else {
         System.out.println("Not Found");
     }
   }
}