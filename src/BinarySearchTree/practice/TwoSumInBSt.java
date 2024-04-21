package BinarySearchTree.practice;

import BinaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TwoSumInBSt {
    public static void main(String[] args) {

        System.out.println("Rahul khichar");
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        Stack<TreeNode> st = new Stack<>();
        Set<Integer> mp = new HashSet<>();
        TreeNode currNode = root;
        while (currNode != null || !st.isEmpty()) {

            while (currNode != null) {
                st.add(currNode);
                currNode = currNode.left;
            }

            currNode = st.pop();
            int value = currNode.val;
            if (mp.contains(k - value)) return true;
            if (!mp.contains(value)) mp.add(value);
            currNode = currNode.right;

        }

        return false;

    }
}
