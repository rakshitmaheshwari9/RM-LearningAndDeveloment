package BinarySearchTree.practice;

import BinaryTree.TreeNode;

public class deleteNode {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public TreeNode addSubTreeToTree(TreeNode root, TreeNode subTree) {
        if (root == null) return subTree;
        if (subTree == null) return root;

        if (root.val > subTree.val)
            root.left = addSubTreeToTree(root.left, subTree);
        else
            root.right = addSubTreeToTree(root.right, subTree);

        return root;

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode rootLeft = root.left;
            rootLeft.right = addSubTreeToTree(root.right, rootLeft.right);
            return rootLeft;

        }

        return root;

    }


}
