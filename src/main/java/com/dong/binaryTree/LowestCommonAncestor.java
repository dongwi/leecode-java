package com.dong.binaryTree;

public class LowestCommonAncestor {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        TreeNode helper = helper(root, o1, o2);
        return helper.val;
    }

    public TreeNode helper(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }
        TreeNode left = helper(root.left, o1, o2);
        TreeNode right = helper(root.right, o1, o2);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
