package BinarySearchTree.practice;


import java.util.ArrayList;
import java.util.List;

public class PredecessorAndSuccessorInBST {

    public static int pre = -1;
    public static int post = -1;

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }


    public static void inorderTraversal(TreeNode root, int value) {

        if (root == null) return;
        inorderTraversal(root.left, value);
        if (root.data < value) {
            pre = root.data;
        } else if (root.data > value && post != -1) {
            post = root.data;
            return;
        }

        inorderTraversal(root.right, value);
    }

    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root, key);
        ans.add(pre);
        ans.add(post);
        return ans;
    }

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    ;
}
