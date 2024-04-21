package BinarySearchTree.practice;

import BinarySearchTree.TreeNode;

public class CeilValueInBinarySearchTree {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

//this one is the correct solution rahul khichar
    public static int findCeil(TreeNode<Integer> node, int x) {
        if (node == null) return -1;


        if (x == node.data) return x;

        if (x < node.data) {
            int leftGreater = findCeil(node.left, x);
            if (leftGreater == -1) return node.data;
            return leftGreater;
        }

        return findCeil(node.right, x);

    }


}
