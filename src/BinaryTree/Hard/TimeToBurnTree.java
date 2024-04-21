package BinaryTree.Hard;

import java.util.ArrayList;
import java.util.List;

public class TimeToBurnTree {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
        // Write your code here.

        List<BinaryTreeNode<Integer>> list = findLevelTillNode(root, start);
        int ans = 0;
        for (int index = 0; index < list.size(); index++) {

            if (index == 0) {
                int height = maxHeight(list.get(index));
                ans = Math.max(height, ans);
            } else {
                BinaryTreeNode<Integer> parent = list.get(index);
                BinaryTreeNode<Integer> child = list.get(index - 1);
                int height;
                if (parent.left != null && parent.left.data == child.data) {
                    height = maxHeight(parent.right) + index;
                } else {
                    height = maxHeight(parent.left) + index;
                }
                ans = Math.max(height, ans);

            }
        }

        return ans;
    }

    public static int maxHeight(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);

    }

    public static boolean find(BinaryTreeNode<Integer> root, int start) {
        if (root == null) return false;
        if (root.data == start) return true;
        return find(root.left, start) || find(root.right, start);
    }

    public static List<BinaryTreeNode<Integer>> findLevelTillNode(BinaryTreeNode<Integer> root, int start) {
        List<BinaryTreeNode<Integer>> list = null;
        if (root == null) return null;
        if (root.data == start) {
            list = new ArrayList<>();
            list.add(root);
            return list;
        }
        boolean isLeft = find(root.left, start);
        if (isLeft) {
            list = findLevelTillNode(root.left, start);
        } else {
            list = findLevelTillNode(root.right, start);
        }
        list.add(root);
        return list;

    }

    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
}
