package BinarySearchTree.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeTwoBinarySearchTree {


    public static void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        TreeNode currNode = root;
        while (currNode != null || !st.isEmpty()) {
            while (currNode != null) {
                st.push(currNode);
                currNode = currNode.left;
            }
            currNode = st.pop();
            list.add(currNode.data);
            if (currNode.right != null) currNode = currNode.right;
            else currNode = null;
        }

    }

    public static void preOrderTraversal(TreeNode root, List<Integer> list) {

        if (root == null) return;
        preOrderTraversal(root.left, list);
        list.add(root.data);
        preOrderTraversal(root.right, list);
    }

    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        // Write your code here.
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preOrderTraversal(root1, list1);
        preOrderTraversal(root2, list2);
        List<Integer> ans = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        while (index1 < list1.size() && index2 < list2.size()) {

            if (list1.get(index1) < list2.get(index2)) {
                ans.add(list1.get(index1));
                index1++;
            } else {
                ans.add(list2.get(index2));
                index2++;
            }
        }

        while (index1 < list1.size()) {
            ans.add(list1.get(index1));
            index1++;

        }

        while (index2 < list2.size()) {

            ans.add(list2.get(index2));
            index2++;
        }


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

        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    }

    ;
}
