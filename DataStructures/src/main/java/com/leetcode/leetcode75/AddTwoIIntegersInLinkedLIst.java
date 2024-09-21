package com.leetcode.leetcode75;

public class AddTwoIIntegersInLinkedLIst {
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

        ListNode result = addTwoNumbers(l1,l2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify result list creation
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;  // Pointer to the result list
        int carry = 0;  // Carry to handle digits > 9

        // Loop through both lists until all digits and carry are processed
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;  // Get the value from l1 or 0 if l1 is done
            int y = (l2 != null) ? l2.val : 0;  // Get the value from l2 or 0 if l2 is done
            int sum = carry + x + y;  // Calculate sum including carry

            carry = sum / 10;  // Update carry (1 if sum >= 10)
            current.next = new ListNode(sum % 10);  // Create a new node for the current digit

            current = current.next;  // Move to the next position in the result list
            if (l1 != null) l1 = l1.next;  // Move to the next node in l1, if available
            if (l2 != null) l2 = l2.next;  // Move to the next node in l2, if available
        }

        // If there's any carry left at the end, create a new node for it
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;  // Return the resulting list (ignoring the dummy head)
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
