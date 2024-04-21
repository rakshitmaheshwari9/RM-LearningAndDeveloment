package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return symmetric(root.left, root.right);

    }

    public boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        return symmetric(left.right, right.left) && symmetric(left.left, right.right);
    }
}
