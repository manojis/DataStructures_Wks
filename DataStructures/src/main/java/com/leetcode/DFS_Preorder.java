package com.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Manoj.Mohanan Nair
 * @Date 10/5/19
 *
 * Depth first search with preorder traversal
 * Top --> Bottom and then left --> Right
 * Hence we do a reverse of the node's children
 * traversing during adding to stack happens from left to right format
 * as against the right to left in post order traversal
 */
public class DFS_Preorder {
    public static void main(String[] args){

    }

    public static List<Integer> preOrderTraversal(Node root){
        LinkedList<Node> stack = new LinkedList<Node>();
        LinkedList<Integer> output = new LinkedList<Integer>();

        if(root== null){
            return output;
        }
        while(!stack.isEmpty()) {
            Node input = stack.pop();
            if(!input.children.isEmpty()){
                Collections.reverse(input.children);
                for(Node temp : input.children){
                    stack.add(temp);
                }
            }
            output.add(input.val);
        }
        return output;
    }
}


