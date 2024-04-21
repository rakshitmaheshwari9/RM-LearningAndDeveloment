package BinarySearchTree.practice;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecoveryBinarySearchTree {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public void recoverTree(TreeNode root) {

//        validBinaryTree(root, null, null);
        List<TreeNode> list = new ArrayList<>();
        inorderTraversal(root, list);
        List<Integer> secondAns = new ArrayList<>();

        for (int index = 0; index < list.size(); index++) {

            secondAns.add(list.get(index).val);
        }

        secondAns.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        for (int index = 0; index < list.size(); index++) {

            list.get(index).val = secondAns.get(index);
        }


    }

    public void inorderTraversal(TreeNode treeNode, List<TreeNode> ans) {
        if (treeNode == null) return;
        inorderTraversal(treeNode.left, ans);
        ans.add(treeNode);
        inorderTraversal(treeNode.right, ans);
    }


    public void validBinaryTree(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return;

        if (min != null && root.val < min.val) {
            int value = min.val;
            min.val = root.val;
            root.val = value;
        }

        if (max != null && root.val > max.val) {
            int value = max.val;
            max.val = root.val;
            root.val = value;
        }
        validBinaryTree(root.left, min, root);
        validBinaryTree(root.right, root, max);


    }
}
