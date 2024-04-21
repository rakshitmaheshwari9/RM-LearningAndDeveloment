package BinarySearchTree.practice;

import BinaryTree.TreeNode;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public boolean findNode(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (p == null) return false;

        if (root.val == p.val) return true;

        return findNode(root.left, p) || findNode(root.right, p);

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val == p.val || root.val == q.val) return root;

        boolean isLeftPThere = findNode(root.left, p);
        boolean isRightQThere = findNode(root.left, q);

        if (isLeftPThere && isRightQThere) return lowestCommonAncestor(root.left, p, q);
        if (!isLeftPThere && !isRightQThere) return lowestCommonAncestor(root.right, p, q);
        return root;

    }
}
