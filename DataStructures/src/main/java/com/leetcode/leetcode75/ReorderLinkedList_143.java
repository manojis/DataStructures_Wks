package com.leetcode.leetcode75;

public class ReorderLinkedList_143 {
  public static void main(String[] args) {
    ReorderLinkedList_143 reorderLinkedList = new ReorderLinkedList_143();
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(3);
    l1.next.next.next = new ListNode(4);
    l1.next.next.next.next = new ListNode(5);
    l1.next.next.next.next.next = new ListNode(6);
    reorderLinkedList.reorderList(l1);
    ListNode.printList(l1);
  }

  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }

    ListNode slow = head; // this finally points to middle node
    ListNode fast = head; // This finally points to tail

    // find the middle node
    while(fast!= null && fast.next!=null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    //needed for reversing. slow will move again and middle will stay as middle pointer
    ListNode prev = null;
    ListNode temp = null;
    ListNode curr = slow;
    // Reverse all the nodes from the middle to the end
    while(curr != null) {
      temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }

    // prev node becomes the tail node pointing to 6
    // slow &curr points to a null node.
    // merge them from head to middle and tail to middle into one
    ListNode dummyHead = head;
    ListNode dummyTail = prev;
    while(dummyHead.next !=null && dummyTail.next!= null) {
      ListNode tForward = dummyHead.next;
      dummyHead.next = dummyTail;
      dummyHead = tForward;
      ListNode tBackward = dummyTail.next;
      dummyTail.next = tForward;
      dummyTail = tBackward;
    }
  }
}
