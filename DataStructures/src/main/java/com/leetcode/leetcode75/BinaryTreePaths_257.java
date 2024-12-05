package com.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> paths = new ArrayList<>();
        List<List<Integer>> fullPath = new ArrayList<>();

        dfs(root, fullPath, paths);

        List<String> result = fullPath.parallelStream()
                .map(list -> list.parallelStream()
                        .map(String::valueOf)
                        .collect(Collectors.joining("->")))
                .collect(Collectors.toList());

        return result;
    }

    public void dfs(TreeNode root, List<List<Integer>> fullPath, List<Integer> paths) {
        if (root == null) {
            return;
        }
        paths.add(root.val);

        if(root.left == null && root.right == null) {
            fullPath.add(new ArrayList<>(paths));
        } else {
            dfs(root.left, fullPath, paths);
            dfs(root.right, fullPath, paths);
        }
        // this is needed as everytime the recursion tracks back we need to clear the nodes that we are tracking back
        paths.remove(paths.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);

        BinaryTreePaths_257 solution = new BinaryTreePaths_257();
        System.out.println("Sum of root-to-leaf paths: " + solution.binaryTreePaths(root));
    }
}
