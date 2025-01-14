package BinarySearchTree.practice;

import BinaryTree.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);

    }


    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
