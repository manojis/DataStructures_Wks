package com.linkedList;

import java.util.LinkedList;

public class Reverse_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> input = new LinkedList<String>();
		input.add("abc");
		input.add("def");
		input.add("ghi");
		input.add("jkl");
		input.add("mno");
		input.add("pqr");
		System.out.println(""+ input);
		//ListNode output= reverseList(input);
	}


	public ListNode reverseList(ListNode head) {
		if(head==null||head.next==null)
			return head;

		ListNode p1 = head;
		ListNode p2 = p1.next;

		head.next = null;
		while(p1!=null&& p2!=null){
			ListNode t = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = t;
		}

		return p1;
	}
}

class ListNode{
	int data;
	ListNode next;
	ListNode(int element){
		data = element;
	}

}
