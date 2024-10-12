package com.HackerRank.Algorithms;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Manoj.Mohanan Nair
 * @Date 10/11/24
 */
public class InsertNodeAtPosition {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

    }
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // if the position is 0, then replace the head with new node
        // if the head is null, return new node as the head?
        // if the position > number of elements, return head?
        SinglyLinkedListNode root = llist;
        int i = 0;
        while(i<=position) {
            if (i == position) {
                SinglyLinkedListNode node = new SinglyLinkedListNode();
                node.data = data;
                node.next = llist.next;
                llist.next = node;
            } else {
                llist = llist.next;
                i++;
            }
        }
        return root;
    }
}
class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

}
