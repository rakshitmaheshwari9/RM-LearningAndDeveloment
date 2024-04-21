package BinaryTree.Hard;

import BinaryTree.TreeNode;

public class ContructBinaryTreeInOrderAndPostOrder {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postOrder = {9, 15, 7, 20, 3};
        ContructBinaryTreeInOrderAndPostOrder contructBinaryTreeInOrderAndPostOrder = new ContructBinaryTreeInOrderAndPostOrder();
        TreeNode treeNode = contructBinaryTreeInOrderAndPostOrder.buildTree(inorder, postOrder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTreeHelper(inorder, postorder, 0, n - 1, 0, n - 1);
//        if (inorder.length == 0) return null;
//        int n = postorder.length;
//        int number = postorder[n - 1];
//
//        int index = 0;
//        for (int i = 0; i < inorder.length; i++) {
//            if (inorder[i] == number) {
//                index = i;
//                break;
//            }
//        }
//
//        int left[] = new int[index];
//        int right[] = new int[inorder.length - 1 - index];
//        for (int i = 0; i < left.length; i++) {
//            left[i] = inorder[i];
//        }
//
//        for (int i = 0; i < right.length; i++) {
//            right[i] = inorder[i + index + 1];
//        }
//
//        int leftPostOrder[] = new int[left.length];
//        int rightPostOrder[] = new int[right.length];
//        for (int i = 0; i < index; i++) {
//            leftPostOrder[i] = postorder[i];
//        }
//
//        for (int i = 0; i < right.length; i++) {
//            rightPostOrder[i] = postorder[i + index];
//        }
//
//        TreeNode leftNode = buildTree(left, leftPostOrder);
//        TreeNode rightNode = buildTree(right, rightPostOrder);
//        TreeNode treeNode = new TreeNode(number, leftNode, rightNode);
//        return treeNode;

    }

    public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int startInorder, int endInorder, int startPostorder, int endPostOrder) {

        if (startInorder > endInorder || startPostorder > endPostOrder) return null;

        int number = postorder[endPostOrder];

        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == number) {
                index = i;
                break;
            }
        }

        TreeNode leftTree = buildTreeHelper(inorder, postorder, startInorder, index - 1, startPostorder, index - 1);
        TreeNode rightTree = buildTreeHelper(inorder, postorder, index + 1, endInorder, index, endPostOrder - 1);

        TreeNode treeNode = new TreeNode(number, leftTree, rightTree);
        return treeNode;

    }
}