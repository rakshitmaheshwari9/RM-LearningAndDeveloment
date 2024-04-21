package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }


    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftValue = maxDepth(root.left);
        int rightValue = maxDepth(root.right);
        return 1 + Math.max(leftValue, rightValue);
    }

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
