/*
package com.linkedList;

import java.util.*;

public class LinkedList {	
	
	//A linked list object holds a reference to the first node, and each node holds a reference to the next node
	//Here variable "first" is the linked list object.
	class Node{
		public Object data;
		public Node next;
	}
	
	private Node first;
	
	public LinkedList(){
		first = null;
	}
	
	public Object getFirstObject(){
		
		if(first == null){
			throw new NoSuchElementException();
		}
		System.out.println(first.data);
		return first.data;
	}
	
	public void addNode(Object element){
		
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
	}
	public void removeNode(){
		if(first == null){
			throw new NoSuchElementException();
		}else{
			Node remove = first.next;
			
		}
	}
	public Node insert(Node head,int data) {
		// This is a "method-only" submission. 
		// You only need to complete this method. 
		 if(head == null) {
		        Node node = new Node();
		        head = node;
		        head.data = data;
		        head.next = null;
		        return head;
		    }

		    while(head != null) {
		        head = head.next;
		    }
		    //head.next = new Node(data, null);
		    head.data = data;
		    head.next = null;
		    return head;
		}
	public ListIterator listIterator(){
		return new LinkedListIterator();
	}
	class LinkedListIterator implements ListIterator{
		
		private Node previous;
		private Node position;
		
		public LinkedListIterator(){
			position = null;
			previous = null;
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object manojElement = "firstReport";
		LinkedList manoj = new LinkedList();
		System.out.println(manoj);
		manoj.getFirstObject();
		manoj.addNode(manojElement);	

	}
}
*/
