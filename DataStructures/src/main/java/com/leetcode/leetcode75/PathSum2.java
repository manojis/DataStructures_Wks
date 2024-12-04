package com.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manoj.Mohanan Nair
 * @Date 12/3/24
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // start from the root node. make a call to dfs using both left and right node one by one
        // keep a track of the remaining sum.
        // keep a track of the values in a 1 d list
        // if there is no left or right node and the remaining sum is zero, add that list to final result list which is a 2d
        // else continue with dfs, if the remaining sum is < 0 then ignore the rest of the dfs
        List<Integer> traverseList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int remainingSum = targetSum;
        dfs(root, traverseList, result, remainingSum);
        return result;
    }

    public void dfs(TreeNode root,List<Integer> traverseList,
                    List<List<Integer>> result, int remainingSum) {
        if (root == null) {
            return;
        }

        traverseList.add(root.val);

        if (root.left == null && root.right == null && remainingSum == root.val) {
            result.add(new ArrayList<>(traverseList));
        } else {
            remainingSum = remainingSum - root.val;
            dfs(root.left, traverseList, result, remainingSum);
            dfs(root.right, traverseList, result, remainingSum);
        }
        traverseList.remove(traverseList.size() - 1);
    }

    public static void main(String[] args) {
        PathSum2 solution = new PathSum2();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> paths = solution.pathSum(root, targetSum);

        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
