package com.linkedList;

import java.util.Stack;

/**
 * @author Manoj.Mohanan Nair
 * @Date 9/6/19
 */
public class LinkedList_Palindrome {

    public static void main(String[] args){
        Node a = new Node("amanoj");
        Node b = new Node("bmanoj");
        Node c = new Node("rmanoj");
        Node d = new Node("dmanoj");
        Node e = new Node("cmanoj");
        Node f = new Node("bmanoj");
        Node g = new Node("amanoj");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = null;
        boolean status = verifyPalindrome(a);
        System.out.print(status);
    }
    public static boolean verifyPalindrome(Node a){

        boolean status = false;
        Node temp = a;
        Stack<String> result = new Stack<String>();

        while(temp!=null){
            result.add(temp.data);
            temp = temp.next;
        }
        int size = 0;
        if((result.size()) % 2 != 0){
            size = (int) Math.ceil(result.size()/2);
        }else{
            size = (result.size())/2;
        }
        if(!result.isEmpty()){
            // compare each element pushed out from stack with
            // each element from the head of the linkedlist
            for(int i=0; i<=size; i++){
                if(a.data != result.pop()){
                    status = false;
                    break;
                }
                status = true;
                a = a.next;
            }
        }
        return status;
    }
}

class Node{
    String data;
    Node next;
    Node(String element) {
        data = element;
        next = null;
    }
}
