/**
 * 
 */
package com.sorting.selection;

import java.util.Arrays;

/**
 * @author 212561694
 *
 */
public class Selection_Sorter {
	
	private int anArray[];

	Selection_Sorter(int a[]){
		anArray =  a;
	}

	public void sort(){
		
		for(int i=0;i<anArray.length-1;i++){
			int minpos =  minimumPosition(i);
			swap(minpos,i);
		}
		System.out.println("After selection"+ Arrays.toString(anArray));
	}
	public int minimumPosition(int i){
		
		int minpos = i;
		for(int j=i+1;j<anArray.length;j++){
			if(anArray[j]<anArray[minpos])
				minpos = j;
		}		
		return minpos;
	}
	public void swap(int minpos,int i){
		int temp;
		temp = anArray[minpos];
		anArray[minpos] = anArray[i];
		anArray[i] = temp;		
	}
}
