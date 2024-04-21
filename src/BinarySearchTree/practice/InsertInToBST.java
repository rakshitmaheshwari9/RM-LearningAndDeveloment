package BinarySearchTree.practice;

import BinaryTree.TreeNode;

public class InsertInToBST {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode ans = new TreeNode(val);
            return ans;
        }


        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;

    }
}
