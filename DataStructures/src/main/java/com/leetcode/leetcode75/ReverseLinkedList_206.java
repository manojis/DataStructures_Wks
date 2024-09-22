package com.leetcode.leetcode75;

public class ReverseLinkedList_206 {

  public static void main(String [] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(3);
    l1.next.next.next = new ListNode(4);
    l1.next.next.next.next = new ListNode(5);

    System.out.print("Given Linked list:");
    ListNode.printList(l1);

    // reverse the given linkedlist
    ListNode reversedHead = reverseList(l1);

    System.out.print("\nReversed Linked List:");
    ListNode.printList(reversedHead);

    System.out.print("\n Original head wont give the entire linked list:");
    ListNode.printList(l1);
  }

  public static ListNode reverseList(ListNode head) {
    // setting a dummy head to return back the head
    ListNode current = head;
    ListNode prev = null;
    // for every node.next it should start pointing to the prev node
    while(current != null) {
      // current.next is pointed to new node to retain the node
      ListNode next = current.next;
      // now current.next is made to point to prev;
      current.next = prev;
      // move the prev to current. now both prev and current is the same node
      prev = current;
      // move the current now to next, now both next and current is the same node.
      current = next;
    }
    //now the current is null or is the pointer at the tail side, so return the prev;
    return prev;
  }
}
