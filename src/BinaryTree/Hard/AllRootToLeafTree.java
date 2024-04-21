package BinaryTree.Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllRootToLeafTree {

    public static void main(String[] args) {
        System.out.println("Rahul khichar");
    }


    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<BinaryTreeNodeWithString> queue = new LinkedList<>();
        queue.add(new BinaryTreeNodeWithString(root, ""));

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size > 0) {
                size--;
                BinaryTreeNodeWithString binaryTreeNodeWithString = queue.poll();
                BinaryTreeNode binaryTreeNode = binaryTreeNodeWithString.binaryTreeNode;
                String str = binaryTreeNodeWithString.str;

                if (binaryTreeNode.left == null && binaryTreeNode.right == null) {
                    ans.add(str + binaryTreeNode.data);
                }

                if (binaryTreeNode.left != null) {
                    queue.add(new BinaryTreeNodeWithString(binaryTreeNode.left, new String(str + binaryTreeNode.data + " ")));
                }

                if (binaryTreeNode.right != null) {
                    queue.add(new BinaryTreeNodeWithString(binaryTreeNode.right, new String(str + binaryTreeNode.data + " ")));
                }

            }
        }
        return ans;
    }

    static class BinaryTreeNodeWithString {
        String str;
        BinaryTreeNode binaryTreeNode;

        BinaryTreeNodeWithString(BinaryTreeNode binaryTreeNode, String str) {
            this.binaryTreeNode = binaryTreeNode;
            this.str = str;
        }

    }

    class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    ;

}
