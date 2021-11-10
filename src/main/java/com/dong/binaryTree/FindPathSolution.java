package com.dong.binaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class FindPathSolution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        findPath(root, target, temp);
        result.add(temp);
        return result;
    }

    public void findPath(TreeNode root, int target, List<Integer> temp) {
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ArrayList<Integer> res = new ArrayList<>(temp);
                result.add(res);
            }
        } else {
            if (root.left != null) {
                findPath(root.left, target - root.val, temp);
            }
            if (root.right != null) {
                findPath(root.right, target - root.val, temp);
            }
        }
        if (temp.size() != 0) {
            temp.remove(temp.size() - 1);
        }
    }
}
