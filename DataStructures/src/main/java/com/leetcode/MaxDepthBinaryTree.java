package com.leetcode;

import java.util.Stack;

public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        //root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        //root.left.left = new TreeNode(4);
        //root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(4);

        MaxDepthBinaryTree maxDepthBinaryTree = new MaxDepthBinaryTree();
        System.out.println("Maximum Depth: " + maxDepthBinaryTree.maxDepth_recursion(root));
        System.out.println("Maximum Depth: " + maxDepthBinaryTree.maxDepth_iteration(root));
    }

    /**
     * Using Stack is much better and easier to understand
     * @param root
     * @return
     */
    private static int maxDepth_iteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        Stack<Integer> depth = new Stack();
        if(root == null) {
            return 0;
        }

        int maxDepth = 0;
        stack.push(root);
        depth.push(1);

        while(!stack.isEmpty()) {
            root = stack.pop();
            int currentDepth = depth.pop(); // return and remove the last element in the linkedList.

            if(root.right != null) {
                stack.push(root.right);
                depth.push(currentDepth +1);
            }
            if(root.left!= null) {
                stack.push(root.left);
                depth.push(currentDepth +1);
            }
            maxDepth = Math.max(maxDepth,currentDepth);
        }
        return maxDepth;
    }

    private static int maxDepth_iteratiion(TreeNode root) {
        if(root != null) {
            return 0;
        }
        int depth = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(stack!= null) {
            root = stack.pop();
            if (root.right!= null) {
                stack.push(root.right);
            }
            if (root.left!= null) {
                stack.push(root.left);
            }
        }
        return depth;
    }



    /**
     * Recursive implementation
     * @param root
     * @return
     */
    private static int maxDepth_recursion(TreeNode root) {
        if (root== null) {
            return 0;
        }
        int left = maxDepth_recursion(root.left);
        int right = maxDepth_recursion(root.right);
        // find out whichever is the highest and include the current one as well in the count
        return Math.max(left,right) +1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
