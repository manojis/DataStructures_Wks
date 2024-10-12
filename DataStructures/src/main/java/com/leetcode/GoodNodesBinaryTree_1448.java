package com.leetcode;

import org.apache.commons.math3.util.Pair;

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
        Stack<PairNode> stack = new Stack();
        stack.push(new PairNode(root, root.val));
        int count=0;

        while(!stack.isEmpty()) {
            // check the value of the left and right nodes of the root node and if they are greater update the count else continue
            PairNode curr = stack.pop();
            if (curr.maxSoFar <= curr.root.val) {
                count++;
            }

            if (curr.root.left != null) {
                stack.push(new PairNode(curr.root.left, Math.max(curr.root.val, curr.maxSoFar)));
            }

            if (curr.root.right != null) {
                stack.push(new PairNode(curr.root.right, Math.max(curr.root.val, curr.maxSoFar)));
            }
        }
        return count;
    }
}

class PairNode {
    int maxSoFar;
    TreeNode root;

    PairNode(TreeNode node, int maxSoFar) {
        this.maxSoFar = maxSoFar;
        this.root = node;
    }
}
