package BinaryTree.Hard;

import BinaryTree.TreeNode;

public class LowestCommanAncestor {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public boolean findRoot(TreeNode root, TreeNode leafNode) {
        if (root == null) return false;
        if (root.val == leafNode.val) return true;

        return findRoot(root.left, leafNode) || findRoot(root.right, leafNode);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val == p.val || root.val == q.val) return root;

        boolean isLeft = findRoot(root.left, p);
        boolean isRight = findRoot(root.left, q);


        if (isLeft && isRight) return lowestCommonAncestor1(root.left, p, q);
        if (!isLeft && !isRight) return lowestCommonAncestor1(root.right, p, q);

        return root;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // I didn't get it
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        else if (right == null) return left;
        return root;

    }
}
