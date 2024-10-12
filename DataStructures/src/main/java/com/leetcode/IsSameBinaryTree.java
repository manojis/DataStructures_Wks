package com.leetcode;

import java.util.Stack;

/**
 * @author Manoj.Mohanan Nair
 * @Date 10/11/24
 */
class PairNodes {
    TreeNode p;
    TreeNode q;
    PairNodes(TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
    }
}
public class IsSameBinaryTree {
    /**
     * push this two nodes into a stack<PairNodes> for comparison
      */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // create a stack with PairNodes data structure
        Stack<PairNodes> pairNodes = new Stack<>();
        // else Push the root nodes p and q into the stack
        pairNodes.push(new PairNodes(p, q));

        while(!pairNodes.isEmpty()) {
            PairNodes input = pairNodes.pop();
            // check if both p and q are equal, if so then return true;
            if (input.p == null && input.q == null) {
                continue;
            }

            if(input.p == null || input.q == null) {
                return false;
            }

            if (input.p.val != input.q.val) {
                return false;
            }
            // left or right nodes while pushing into stack can be null and that will be checked in the next iteration.
            pairNodes.push(new PairNodes(input.p.right, input.q.right));
            // left or right nodes while pushing into stack can be null and that will be checked in the next iteration.
            pairNodes.push(new PairNodes(input.p.left, input.q.left));
        }
        return true;
    }
    public static void main (String [] args) {
        TreeNode p = new TreeNode(2);
        //root.left = new TreeNode(2);
        p.right = new TreeNode(4);
        //root.left.left = new TreeNode(4);
        //root.left.right = new TreeNode(5);
        p.right.left = new TreeNode(10);
        p.right.right = new TreeNode(8);
        p.right.right.right = new TreeNode(4);

        TreeNode q = new TreeNode(2);
        //root.left = new TreeNode(2);
        q.right = new TreeNode(4);
        //root.left.left = new TreeNode(4);
        //root.left.right = new TreeNode(5);
        //q.right.left = new TreeNode(10);
        q.right.right = new TreeNode(8);
        q.right.right.right = new TreeNode(4);

        System.out.println("Is Same Binary Tree: " + IsSameBinaryTree.isSameTree(p, q));
    }

    public boolean isSameTree_recursion(TreeNode p, TreeNode q) {
        // check if both p and q are null
        boolean result = false;
        if(p == null && q == null) {
            return true;
        }
        if (p==null || q==null) {
            return false;
        }
        if (p != null && q!= null) {
            if (p.val == q.val) {
                return isSameTree_recursion(p.left, q.left) && isSameTree_recursion(p.right, q.right);
            } else {
                return false;
            }
        }
        return result;
    }
}
