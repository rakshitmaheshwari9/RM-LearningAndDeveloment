package BinaryTree.Hard;

import BinaryTree.TreeNode;

public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;

    }
}
