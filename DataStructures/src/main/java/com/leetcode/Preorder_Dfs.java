package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Preorder_Dfs {
    public static void main(String[] args){
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i= 0; i<10; i++){
            int x = stack.get(i);
        }
    }
    /**
     * This will run at the moment since we dont have a tree for printing out the preorder values.
     * */
    public List<Integer> preorder(Node root) {
        LinkedList<Node> dfsStack = new LinkedList<Node>();
        LinkedList<Integer> output = new LinkedList<Integer>();

        if(root == null){
            return output;
        }

        dfsStack.push(root);
        while(!dfsStack.isEmpty()){

            // polllast() takes the last inserted element and check for its childrens
            Node node = dfsStack.pollLast();
            output.add(node.val);

            // inputting each of the nodes in the list of the children
            // in a reverse manner into the linkedlist.
            if(!node.children.isEmpty()){
                for(int i=node.children.size()-1; i>=0; i--){
                    dfsStack.add(node.children.get(i));
                }
            }
            /**  // or can be reversed as below
             Collections.reverse(node.children);
             for(Node atom: node.children){
             dfsStack.add(atom);
             }
             */
        }
        return output;
    }
}

// Definition for a Node.
class NodeX {
    public int val;
    public List<Node> children;

    public NodeX() {}

    public NodeX(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};