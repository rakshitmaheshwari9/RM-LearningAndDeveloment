package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RightView {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        RightView rightView = new RightView();

        int[] input = {1, 2, 3, -1, 5, -1, 4};
        TreeNode treeNode = new TreeNode();

        TreeNode root = treeNode.buildTreePreOrder(input);
        System.out.println(rightView.rightSideView(root));
    }


    public void dfs(TreeNodeLevel node, Map<Integer, Integer> mp) {

        TreeNode treeNode = node.treeNode;
        int level = node.level;
        if (!mp.containsKey(level)) mp.put(level, treeNode.val);
        if (node == null) return;
        if (treeNode.right != null) dfs(new TreeNodeLevel(treeNode.right, level + 1), mp);
        if (treeNode.left != null) dfs(new TreeNodeLevel(treeNode.left, level + 1), mp);
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        dfs(new TreeNodeLevel(root, 0), mp);
        for (int value : mp.values()) ans.add(value);
        return ans;

    }

    public class TreeNodeLevel {

        int level;
        TreeNode treeNode;

        TreeNodeLevel(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;

        }
    }
}
