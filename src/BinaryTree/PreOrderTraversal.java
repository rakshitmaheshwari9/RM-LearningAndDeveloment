package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PreOrderTraversal {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");

        int[] arr = {1, -1, 2, 3};

        TreeNode treeNode = new TreeNode();

        TreeNode treeNode1 = treeNode.buildTreePreOrder(arr);

        treeNode.inorderTraversal(treeNode1);

        Queue<Integer>qe=new LinkedList<>();
//        qe.ad

        System.out.println(treeNode1);


    }

    public void travaseral(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        if (root.left != null) {
            travaseral(root.left, ans);
        }
        ans.add(root.val);

        if (root.right != null) {
            travaseral(root.left, ans);
        }

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;
        travaseral(root, ans);

        return ans;
    }
}
