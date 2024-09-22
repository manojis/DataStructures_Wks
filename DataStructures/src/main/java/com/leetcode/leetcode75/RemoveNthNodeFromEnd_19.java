package com.leetcode.leetcode75;

public class RemoveNthNodeFromEnd_19 {
  public static void main(String[] args) {
    RemoveNthNodeFromEnd_19 reorderLinkedList = new RemoveNthNodeFromEnd_19();
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(3);
    l1.next.next.next = new ListNode(4);
    l1.next.next.next.next = new ListNode(5);
    reorderLinkedList.removeNthFromEnd(l1, 2);
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    /**
     * This dummy node in normal situation is not needed but here it helps to handle certain edge cases for LinkedList with just one node etc
     */
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    // one pointer will start from head at regular speed
    ListNode regular = dummy;
    // Another point will always maintain n distance away from regular pointer.
    // This way once this faster pointer reaches the end, the regular one will be n distance away from end and its the one we need.
    ListNode faster = dummy;
    // initially maintain n distance apart.
    for (int i = 0;i<=n;i++) {
      faster = faster.next;
    }
    // maintain the same distance and hop one by one until faster one reaches the end when its null
    while(faster != null) {
      regular = regular.next;
      faster = faster.next;
    }
    // removing the nth node
    regular.next = regular.next.next;
    return dummy.next;
  }

}
