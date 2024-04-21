package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class HeightOfBinaryTree {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftValue = maxDepth(root.left);
        int rightValue = maxDepth(root.right);
        return 1 + Math.max(leftValue, rightValue);
    }
}
