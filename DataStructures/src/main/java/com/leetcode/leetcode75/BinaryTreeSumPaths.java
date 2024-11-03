package com.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Manoj.Mohanan Nair
 * @Date 11/2/24
 */
public class BinaryTreeSumPaths {
    public int sumRootToLeaf(TreeNode root) {
        List<Integer> uniqueDecimals = new ArrayList<>();
        dfs(root, 0, uniqueDecimals);
        return uniqueDecimals.stream().mapToInt(Integer::intValue).sum();
    }

    private void dfs(TreeNode node, int currentValue, List<Integer> uniqueDecimals) {
        if (node == null) {
            return;
        }

        // Update the current binary value
        currentValue = currentValue * 2 + node.val;

        // If it's a leaf node, return the current value
        if (node.left == null && node.right == null) {
            uniqueDecimals.add(currentValue);
            return;
        }

        // Recursively calculate the sum for both subtrees
        dfs(node.left, currentValue, uniqueDecimals);
        dfs(node.right, currentValue, uniqueDecimals);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        BinaryTreeSumPaths solution = new BinaryTreeSumPaths();
        System.out.println("Sum of root-to-leaf paths: " + solution.sumRootToLeaf(root));
    }
}
