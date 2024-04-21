package BinarySearchTree.practice;

import BinarySearchTree.TreeNode;

public class FloorForBST {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public static int Floor(TreeNode<Integer> node, int input) {
        if (node == null) return -1;

        if (node.data == input) return input;

        if (node.data < input) {
            int rightValue = Floor(node.right, input);
            if (rightValue == -1) return node.data;
            return rightValue;
        }

        return Floor(node.left, input);
    }
}
