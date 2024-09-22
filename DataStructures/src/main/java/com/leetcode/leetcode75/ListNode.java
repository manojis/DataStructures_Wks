package com.leetcode.leetcode75;

class ListNode {

  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  // This function prints the contents of the linked list starting from the head
  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(" " + node.val);
      node = node.next;
    }
  }
}
