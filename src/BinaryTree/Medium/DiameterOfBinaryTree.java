package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }


    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftValue = maxDepth(root.left);
        int rightValue = maxDepth(root.right);
        return 1 + Math.max(leftValue, rightValue);
    }

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return  Math.max((leftHeight+rightHeight+1),Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));

    }
}
