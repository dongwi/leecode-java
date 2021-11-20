package com.dong.binaryTree;

import java.util.ArrayList;

public class FindPathSolution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        findPath(result, root, expectNumber, temp);
        return result;
    }

    public void findPath(ArrayList<ArrayList<Integer>> result, TreeNode root, int target, ArrayList<Integer> temp) {
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ArrayList<Integer> res = new ArrayList<>(temp);
                result.add(res);
            }
        } else {
            if (root.left != null) {
                findPath(result, root.left, target - root.val, temp);
            }
            if (root.right != null) {
                findPath(result, root.right, target - root.val, temp);
            }
        }
        if (temp.size() != 0) {
            temp.remove(temp.size() - 1);
        }
    }
}
