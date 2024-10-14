package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
    public static void main(String [] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.left.left = null;
        root.left.left.right = null;
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        BinaryTreeRightSideView_199 ls = new BinaryTreeRightSideView_199();
        TreeNode result = ls.rightSideView(roo);
        System.out.println("Least common ancestor: " +result.val);
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        Queue<PairNodeLevels> queue = new LinkedList<>();
        queue.offer(new PairNodeLevels(root, 1));

        while(!queue.isEmpty()) {
            PairNodeLevels prRoot = queue.poll();
            root = prRoot.node;
            int rootLevel = prRoot.level;

            // check if the next one in the queue is having higher level
            // then add that to the list
            if(queue.isEmpty() || queue.peek().level > rootLevel) {
                System.out.println("the value on the extreme right: " + root.val + " level: " + rootLevel);
                output.add(root.val);
            }
            if(root.left != null) {
                queue.offer(new PairNodeLevels(root.left, rootLevel + 1));
            }
            if (root.right != null) {
                queue.offer(new PairNodeLevels(root.right, rootLevel + 1));
            }
        }
        return output;
    }
}

class PairNodeLevels {
    int level;
    TreeNode node;
    PairNodeLevels(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}


