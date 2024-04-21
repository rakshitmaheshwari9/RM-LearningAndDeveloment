package BinarySearchTree.practice;

import BinaryTree.TreeNode;

public class BstFromPreorder {
    public static void main(String[] args) {

        int[] preorder = {8, 5, 1, 7, 10, 12};

        BstFromPreorder bstFromPreorder = new BstFromPreorder();
        TreeNode ans = bstFromPreorder.bstFromPreorder(preorder);

        System.out.println("Rahul khichar");
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        int n = preorder.length;

        int rootValue = preorder[0];
        int index = n;
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] > rootValue) {
                index = i;
                break;
            }
        }

        int[] leftPreOrder = new int[index - 1];
        int[] rightPreOrder = new int[n - index];

        for (int i = 0; i < leftPreOrder.length; i++) {
            leftPreOrder[i] = preorder[i + 1];
        }

        for (int i = 0; i < rightPreOrder.length; i++) {
            rightPreOrder[i] = preorder[index + i];
        }


        TreeNode treeNode = new TreeNode(preorder[0]);
        treeNode.left = bstFromPreorder(leftPreOrder);
        treeNode.right = bstFromPreorder(rightPreOrder);

        return treeNode;

    }
}
