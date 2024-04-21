package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class SameTree {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) || isSameTree(p.right, q.right);
    }
}
