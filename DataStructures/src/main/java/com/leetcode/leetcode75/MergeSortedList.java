package com.leetcode.leetcode75;

public class MergeSortedList {
  public static void main(String args[]) {
    ListNode l1 = new ListNode(9);
    l1.next = new ListNode(9);
    l1.next.next = new ListNode(9);
        /*l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);*/

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    /*l2.next.next.next = new ListNode(9);*/
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = new ListNode();
    ListNode dummyNewNode = head;

    while(list1 != null && list2 != null) {
      if(list1.val > list2.val) {
        dummyNewNode.next = list2;
        list2 = list2.next;
      } else if(list2.val >= list1.val) {
        dummyNewNode.next = list1;
        list1 = list1.next;
      }
      dummyNewNode = dummyNewNode.next;
    }

    /**
     * The case where list1 or list2  is null.
     * No looping is required as we are connecting the existing pointer of list1 or list2 to dummynode next pointer.
     * so the rest of the list is conneted from here
     */
    if(list1 != null) {
      dummyNewNode.next = list1;
    }
    if(list2 != null) {
      dummyNewNode.next = list2;
    }
    return head.next;
  }
}
