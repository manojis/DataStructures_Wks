package com.leetcode.leetcode75;

public class MiddleLinkedList_876 {
  public static void main(String [] args) {

    MiddleLinkedList_876 middleLinkedList_876 = new MiddleLinkedList_876();
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(3);
    l1.next.next.next = new ListNode(4);
    l1.next.next.next.next = new ListNode(5);
    l1.next.next.next.next.next = new ListNode(6);

    System.out.print("Given Linked list:");
    ListNode.printList(l1);

    // reverse the given linkedlist
    ListNode middleNode = middleLinkedList_876.middleNode(l1);

    System.out.print("\nMiddle Node:");
    ListNode.printList(middleNode);

    System.out.print("\n Original head gives the entire linked list since we didnt disrupt the pointer to next nodes:");
    ListNode.printList(l1);
  }

  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next!=null) {
      fast=fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
