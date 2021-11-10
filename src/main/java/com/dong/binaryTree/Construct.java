package com.dong.binaryTree;

public class Construct {
    public static void main(String[] args) {
    }

    public static class PreSolution {
        public TreeNode buildTree(int []preOrder, int []inOrder) {
            if (preOrder == null || inOrder == null) {
                return null;
            }
            return buildTree(preOrder, inOrder, 0, preOrder.length -1, 0, inOrder.length-1);
        }

        public TreeNode buildTree(int[] preOrder, int[] inOrder, int pStart, int pEnd, int iStart, int iEnd) {
            if (pStart > pEnd || iStart > iEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preOrder[pStart]);
            if (pStart == pEnd) {
                return root;
            }
            int rootIndex = iStart;
            // find the root index of inOrder
            while (rootIndex <= iEnd && inOrder[rootIndex] != root.val)
                rootIndex++;
            int leftCount = rootIndex - iStart;
            root.left = buildTree(preOrder, inOrder, pStart + 1, pStart+leftCount, iStart, rootIndex -1);
            root.right = buildTree(preOrder, inOrder, pStart+leftCount+1, pEnd, rootIndex + 1, iEnd);
            return root;
        }
    }

    public static class PostSolution {
        public TreeNode buildTree(int[] inOrder, int[] postOrder) {
            if (inOrder == null || postOrder == null) {
                return null;
            }
            return buildTree(inOrder, postOrder, 0, inOrder.length -1, 0, postOrder.length - 1);
        }
        public TreeNode buildTree(int[] inOrder, int[] postOrder, int iStart, int iEnd, int pStart, int pEnd) {
            if (iStart > iEnd || pStart > pEnd) {
                return null;
            }
            TreeNode root = new TreeNode(postOrder[pEnd]);
            if (pStart == pEnd) {
                return root;
            }
            int rootIndex = iStart;
            while (rootIndex < iEnd && inOrder[rootIndex] != postOrder[pEnd])
                rootIndex++;
            int leftCount = rootIndex - iStart;
            root.left = buildTree(inOrder, postOrder, iStart, leftCount - 1, pStart, pStart + leftCount -1);
            root.right = buildTree(inOrder, postOrder, leftCount + 1, iEnd, pStart + leftCount + 1, pEnd);
            return root;
        }
    }
}

