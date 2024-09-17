package com.leetcode.leetcode75;

public class AddTwoIIntegersInLinkedLIst {
    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1,l2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode prev1 = null;
        ListNode prev2 = null;
        ListNode nextNode;
        int carry = 0;

        while(l1 != null){
            nextNode = l1.next;
            l1.next = prev1;
            prev1 = l1;
            l1 = nextNode;
        }
        nextNode = null;

        while(l2 != null){
            nextNode = l2.next;
            l2.next = prev2;
            prev2 = l2;
            l2 = nextNode;
        }

        while(prev1!= null || prev2!=null || carry > 0) {
            int val = prev1.val + prev2.val+ carry;

            if (val >= 10) {
                carry = 1;
                val = val-10;
            } else {
                carry = 0;
            }

            ListNode temp = new ListNode(val);
            // Need to understand how to move here
            result.next = temp;
            result = temp;
            result.next = null;

            prev1 = prev1.next;
            prev2 = prev2.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
