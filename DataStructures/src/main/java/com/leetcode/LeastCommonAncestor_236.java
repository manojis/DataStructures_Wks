package com.leetcode;

public class LeastCommonAncestor_236 {
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

        LeastCommonAncestor_236 ls = new LeastCommonAncestor_236();
        TreeNode result = ls.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(6));
        System.out.println("Least common ancestor: " +result.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode right = lowestCommonAncestor(root.right, p, q);
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        if (right!= null && left != null) {
            return root;
        }
        if (right != null) {
            return right;
        }
        return left;
    }
}