package com.leetcode.leetcode75;

public class LinkedListCycle {
  public static void main(String [] args) {

  }

  public boolean hasCycle(ListNode head) {
    // create two pointers for slow and fast pointer
    // Assign two variables fast and slow
    // loop through nodes until fast.next.next != null
    // when fast.next.next = slow.next then return true
        /*             0
                   0       0
          0 0 0 0             0
                   0       0
                       0    */
    if (head == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;

    while(fast!= null && fast.next!= null) {
      if (fast == slow) {
        return true;
      } else {
        slow = slow.next;
        fast = fast.next.next;
      }
    }
    return false;
  }
}
