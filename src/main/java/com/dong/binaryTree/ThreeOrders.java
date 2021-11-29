package com.dong.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeOrders {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        helper(root, pre, in, post);

        int[] preArray = pre.stream().mapToInt(Integer::valueOf).toArray();
        int[] inArray = in.stream().mapToInt(Integer::valueOf).toArray();
        int[] postArray = post.stream().mapToInt(Integer::valueOf).toArray();
        int[][] res = new int[3][];
        res[0] = preArray;
        res[1] = inArray;
        res[2] = postArray;
        return res;
    }

    public void helper(TreeNode root, List<Integer> pre, List<Integer> in, List<Integer> post) {
        if (root == null) {
            return;
        }
        pre.add(root.val);
        helper(root.left, pre, in, post);
        in.add(root.val);
        helper(root.right, pre, in, post);
        post.add(root.val);
    }
}
