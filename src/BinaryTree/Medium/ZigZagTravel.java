package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTravel {
    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st.add(root);
        while (!st.isEmpty() || !st2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (st2.isEmpty()) {
                while (!st.isEmpty()) {
                    TreeNode node = st.pop();
                    list.add(node.val);
                    if (node.left != null) st2.add(node.left);
                    if (node.right != null) st2.add(node.right);

                }
            } else {
                while (!st2.isEmpty()) {
                    TreeNode node = st2.pop();
                    list.add(node.val);
                    if (node.right != null) st.add(node.right);
                    if (node.left != null) st.add(node.left);

                }
            }
            ans.add(list);
        }

        return ans;

    }

}
