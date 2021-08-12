package com.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Manoj.Mohanan Nair
 * @Date 10/5/19
 *
 * Depth first search with postorder traversal
 * left --> Right and then Top --> Bottom
 * when implementing output to tha list from right to left and bottom to top
 * i.e reverse of the pre order and then reverse the entire collection output
 * using Collections.Reverse(output)
 */

public class DFS_PostOrder {
    public static void main(String[] args){
    }

    public List<Integer> postOrderTraversal(Node root){
        LinkedList<Node> stack = new LinkedList<Node>();
        LinkedList<Integer> output = new LinkedList<Integer>();

        stack.add(root);
        while(stack.isEmpty()){
            Node temp = stack.pop();
            if(!temp.children.isEmpty()){
                for(Node input: temp.children){
                    stack.add(input);
                }
            }
            output.add(temp.val);
        }
        Collections.reverse(output);
        return output;
    }
}

