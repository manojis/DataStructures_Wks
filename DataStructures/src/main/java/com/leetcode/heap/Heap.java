package com.leetcode.heap;

public class Heap {

    public static int heapSize = 10;

    //function to get right child of a node of a tree
    public static int getRightChild(int A[], int index) {
        if((((2*index)+1) < A.length && (index >= 1)))
            return (2*index)+1;
        return -1;
    }

    //function to get left child of a node of a tree
    public static int getLeftChild(int A[], int index) {
        if(((2*index) < A.length && (index >= 1)))
            return 2*index;
        return -1;
    }

    //function to get the parent of a node of a tree
    public static int getParent(int A[], int index) {
        if ((index > 1) && (index < A.length)) {
            return index/2;
        }
        return -1;
    }

    public static void maxHeapify(int A[], int index) {
        int leftChildIndex = getLeftChild(A, index);
        int rightChildIndex = getRightChild(A, index);

        // finding largest among index, left child and right child
        int largest = index;

        if ((leftChildIndex <= heapSize) && (leftChildIndex>0)) {
            if (A[leftChildIndex] > A[largest]) {
                largest = leftChildIndex;
            }
        }

        if ((rightChildIndex <= heapSize && (rightChildIndex>0))) {
            if (A[rightChildIndex] > A[largest]) {
                largest = rightChildIndex;
            }
        }

        // largest is not the node, node is not a heap
        if (largest != index) {
            int temp;
            //swapping
            temp = A[largest];
            A[largest] = A[index];
            A[index] = temp;
            maxHeapify(A, largest);
        }
    }

    public static void buildMaxHeap(int A[]) {
        int i;
        for(i=heapSize/2; i>=1; i--) {
            maxHeapify(A, i);
        }
    }

    public static void main(String[] args) {
        //tree is starting from index 1 and not 0
        int A[] = {0, 15, 20, 7, 9, 5, 8, 6, 10, 2, 1};
        buildMaxHeap(A);
        for(int i=1; i<=heapSize; i++) {
            System.out.println(A[i]);
        }
    }
}
