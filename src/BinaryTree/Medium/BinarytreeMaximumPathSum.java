package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class BinarytreeMaximumPathSum {


    public static void main(String[] args) {
        System.out.println("rahul khichar");
    }

    private int maxSum = Integer.MAX_VALUE;

    public int helperService(TreeNode root) {
        if (root == null) return 0;
        int leftSum = helperService(root.left);
        int rightSum = helperService(root.right);
        maxSum = Math.max(leftSum + rightSum + root.val, maxSum);
        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helperService(root);
        return maxSum;
    }
}
