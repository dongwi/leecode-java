package com.dong.binaryTree;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        while (!temp.isEmpty()) {
            ArrayList<Integer> tempResult = new ArrayList<>();
            ArrayList<TreeNode> tempTreeNode = new ArrayList<>();
            temp.forEach(t -> {
                tempResult.add(t.val);
                if (t.left != null) {
                    tempTreeNode.add(t.left);
                }
                if (t.right != null) {
                    tempTreeNode.add(t.right);
                }
            });
            result.add(tempResult);
            temp = tempTreeNode;
        }
        return result;
    }
}
