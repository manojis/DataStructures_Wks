package com.leetcode;

import java.util.Stack;

public class GoodNodesBinaryTree_1448 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        //root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        //root.left.left = new TreeNode(4);
        //root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(4);

        System.out.println("Maximum Depth: " + GoodNodesBinaryTree_1448.goodNodes(root));
    }

    // [2,null,4,10,8,null,null,4]
    public static int goodNodes(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        int currentVal = Integer.MIN_VALUE;
        int count=0;

        while(!stack.isEmpty()) {
            root = stack.pop();
            // check the value of the left and right nodes of the root node and if they are greater update the count else continue
            if (root.val <= root.left.val) {
                count++;
            }
            if (root.val <= root.right.val) {
                count++;
            }

            if (root.right != null) {
                stack.push(root.right);
            }

            if(root.left!= null) {
                stack.push(root.left);
            }
        }
        return count;
    }
}
