package BinaryTree.Hard;

import BinaryTree.TreeNode;

public class ConstructATreeFromPreOrderTraversal {

    public static void main(String[] args) {

        System.out.println("Rahul khichar");

        int preorder[] = {7, -10, -4, 3, -1, 2, -8, 11}, inorder[] = {-4, -10, 3, -1, 7, 11, -8, 2};
        ConstructATreeFromPreOrderTraversal constructATreeFromPreOrderTraversal = new ConstructATreeFromPreOrderTraversal();
        TreeNode treeNode = constructATreeFromPreOrderTraversal.buildTree(preorder, inorder);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int xIndex) {
        if (inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0], null, null);
        // if (xIndex >= preorder.length) return null;

        int number = preorder[xIndex];

        int index = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (number == inorder[i]) {
                index = i;
                break;
            }
        }
        int left[] = new int[index];
        int right[] = new int[inorder.length - index - 1];

        for (int i = 0; i < index; i++) {
            left[i] = inorder[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = inorder[i + index + 1];
        }
        TreeNode leftTree = null;
        TreeNode rightTree = null;
        if (left.length >= 1) leftTree = buildTreeHelper(preorder, left, xIndex + 1);
        if (right.length >= 1) rightTree = buildTreeHelper(preorder, right, xIndex + 1 + left.length);

        TreeNode ans = new TreeNode(number, leftTree, rightTree);
        return ans;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeHelper(preorder, inorder, 0);

    }
}
