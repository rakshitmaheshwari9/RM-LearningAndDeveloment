package BinarySearchTree.practice;

import BinaryTree.TreeNode;

public class KthSmallestInBinarySearchTree {

    int ans = -1;
    int size = 0;

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        preOrderTraversal(root.left);
        size--;
        if (size == 0) ans = root.val;
        preOrderTraversal(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        size = k;
        preOrderTraversal(root);
        return ans;
    }
}
